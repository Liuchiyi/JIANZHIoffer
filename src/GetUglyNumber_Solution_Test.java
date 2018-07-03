/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，
 * 但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */

import java.util.ArrayList;

public class GetUglyNumber_Solution_Test {
    ArrayList<Integer> UglyNumber = new ArrayList();
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0) return 0;
        if(index <= UglyNumber.size()){
            return UglyNumber.get(index-1);
        }
        if(UglyNumber.isEmpty()){
            UglyNumber.add(1);
            UglyNumber.add(2);
            UglyNumber.add(3);
            UglyNumber.add(4);
            UglyNumber.add(5);
        }
        if(index > UglyNumber.size()){
            ModifyUglyNumber(UglyNumber.size(),index);
        }
        return UglyNumber.get(index-1);
    }

    private void ModifyUglyNumber(int size, int index) {
        for (int i = size; i < index; i++) {
            int cur = UglyNumber.get(i - 1);
            long cur_2 = cur * 2;
            long cur_3 = cur * 2;
            long cur_5 = cur * 2;
            for (int j = 0; j < i; j++) {
                if(UglyNumber.get(j) * 2 > cur){
                    cur_2 = (UglyNumber.get(j) * 2 < cur_2 ? UglyNumber.get(j) * 2 : cur_2);
                }
                if(UglyNumber.get(j) * 3 > cur){
                    cur_3 = (UglyNumber.get(j) * 3 < cur_3 ? UglyNumber.get(j) * 3 : cur_3);
                }
                if(UglyNumber.get(j) * 5 > cur){
                    cur_5 = (UglyNumber.get(j) * 5 < cur_5 ? UglyNumber.get(j) * 5 : cur_5);
                }
            }
            if(cur_2 < cur_3) cur = (int)cur_2;
            else cur = (int)cur_3;
            if(cur > cur_5) cur = (int)cur_5;
            UglyNumber.add(cur);
        }
    }

    public static void main(String[] args) {
        GetUglyNumber_Solution_Test test = new GetUglyNumber_Solution_Test();
//        System.out.println(test.GetUglyNumber_Solution(3));
        System.out.println(test.GetUglyNumber_Solution(1500));
    }

}
