

/**
 * 题目描述
 在数组中的两个数字，如果前面一个数字大于后面的数字
 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 并将P对1000000007取模的结果输出。 即输出P%1000000007

 输入描述:
 题目保证输入的数组中没有的相同的数字

 数据范围：
 对于%50的数据,size<=10^4
 对于%75的数据,size<=10^5
 对于%100的数据,size<=2*10^5
 示例1
 输入
 1,2,3,4,5,6,7,0

 输出
 7
 */

//归并排序的延伸

public class InversePairs_Test2 {

    long num;

    public int InversePairs(int [] array) {
        if(array.length == 0 || array.length == 1) return 0;
        num = 0;
        int [] result = new int[array.length];
        merge_sort_helper(array,result,0,array.length - 1);
        return (int)(num%1000000007);
    }

    private  void merge_sort_helper(int[] array, int[] result, int start, int end) {
        if(start >= end) return;
        int length = end - start , mid = (length >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_helper(array,result,start1,end1);
        merge_sort_helper(array,result,start2,end2);
        int k = start;
        int flag = 0;
        while(start1 <= end1 && start2 <= end2){
            if(array[start1] > array[start2]){
                flag++;
                result[k++] = array[start2++];
            }else{
                result[k++] = array[start1++];
                num = num + flag;
            }
        }
        while(start1 <= end1){
            result[k++] = array[start1++];
            num = num + flag;
        }
        while(start2 <= end2){
            result[k++] = array[start2++];
        }
        for (int i = start; i <= end; i++) {
            array[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int [] in = new int[]{1,2,3,4,5,6,7,0};
        InversePairs_Test2 test = new InversePairs_Test2();
        System.out.println(test.InversePairs(in));
    }
}
