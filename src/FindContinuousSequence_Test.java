/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
 * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,
 * 你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，
 * 序列间按照开始数字从小到大的顺序
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class FindContinuousSequence_Test {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        int m = 1, n = sum;
        while(m <= n){
            m++;
            if((sum % m) == 0){
                n = sum / m;
                if(m < n) {
                    if (Helper(m, n) != null) resList.add(Helper(m, n));
                    if (Helper(n, m) != null) resList.add(Helper(n, m));
                }else if(m == n){
                    if (Helper(m, n) != null) resList.add(Helper(m, n));
                }
            }
        }
        if(IsOdd(sum) && sum > 1){
            ArrayList<Integer> list = new ArrayList<>();
            list.add((sum-1) >> 1);
            list.add((sum+1) >> 1);
            resList.add(list);
        }
        Collections.sort(resList, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.get(0) > o2.get(0)) return 1;
                if(o1.get(0) < o2.get(0)) return -1;
                else return 0;
            }
        });
        return resList;
    }

    private ArrayList<Integer> Helper(int m, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int min, max;
        if(IsEven(m) && IsEven(n)) return null;
        if(IsOdd(n)){
            min = m - (n - 1) / 2;
            max = m + (n - 1) / 2;
            if(min > 0){
                for (int i = min; i < max + 1; i++) {
                    list.add(i);
                }
            }else return null;
        }
        if(IsEven(n)){
            min = (m + 1) / 2 - n;
            max = (m - 1) / 2 + n;
            if(min > 0){
                for (int i = min; i < max + 1; i++) {
                    list.add(i);
                }
            }
            else return null;
        }
        return list;
    }

    public boolean IsEven(int n){//是否为偶数
        if((n & 1) == 1) return false;
        else return true;
    }
    public boolean IsOdd(int n){ // 是否为奇数
        if((n & 1) == 0) return false;
        else return true;
    }

    public static void main(String[] args) {
        FindContinuousSequence_Test test = new FindContinuousSequence_Test();
        ArrayList<ArrayList<Integer>> testList = new ArrayList<>();
        testList=test.FindContinuousSequence(9);
        System.out.println(testList);
    }
}
