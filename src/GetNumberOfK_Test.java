/**
 * 统计一个数字在排序数组中出现的次数。
 *
 */
public class GetNumberOfK_Test {

    public int GetNumberOfK(int [] array , int k) {
        int num=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == k) num++;
            if(array[i] > k) break;
        }
        return num;
    }

    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,4,5,6,6,7,8,8,8,8,9,9,9,10};
        GetNumberOfK_Test test = new GetNumberOfK_Test();
        System.out.println(test.GetNumberOfK(array,8));
    }

}
