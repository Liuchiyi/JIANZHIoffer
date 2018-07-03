import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，
 * 在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 对应每个测试案例，输出两个数，小的先输出
 */


public class FindNumbersWithSum_Test {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> resList = new ArrayList<>();
        if(array.length == 0 ||array.length == 1)return resList;
        if(array.length == 2 && array[0] + array[1] != sum) return resList;
        int leftNum=0;
        for (int i = 0; i < array.length-1; i++) {
            leftNum = sum - array[i];
            if(FindNum(leftNum,array,i+1,array.length-1)){
                resList.add(array[i]);
                resList.add(leftNum);
                break;
            }
        }
        return resList;
    }

    private boolean FindNum(int Num, int[] array, int begin, int end) {
        if(begin == end || begin + 1 == end){
            if(array[begin] == Num || array[end] == Num) return true;
            else return false;
        }
        int mid = begin + (end - begin) / 2;
        boolean flag = false;
        if(array[mid] > Num) flag = FindNum(Num,array,begin,mid - 1);
        if(array[mid] < Num) flag = FindNum(Num,array,mid + 1,end);
        if(array[mid] == Num) flag = true;
        return flag;
    }

    public static void main(String[] args) {
        FindNumbersWithSum_Test test = new FindNumbersWithSum_Test();
        int [] array = new int[]{1,2};
        System.out.println(test.FindNumbersWithSum(array,70));
    }

}
