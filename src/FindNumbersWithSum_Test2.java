import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，
 * 在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 对应每个测试案例，输出两个数，小的先输出
 */
public class FindNumbersWithSum_Test2 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> resList = new ArrayList<>();
        if(array.length == 0 ||array.length == 1)return resList;
        if(array.length == 2 && array[0] + array[1] != sum) return resList;
        int begin = 0, end = array.length - 1;
        while (begin < end){
            if(array[begin] + array[end] > sum) end --;
            if(array[begin] + array[end] < sum) begin ++;
            if(array[begin] + array[end] == sum) {
                resList.add(array[begin]);
                resList.add(array[end]);
                break;
            }
        }
        return resList;
    }



    public static void main(String[] args) {
        FindNumbersWithSum_Test2 test = new FindNumbersWithSum_Test2();
        int [] array = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(test.FindNumbersWithSum(array,50));
    }

}
