

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 二分查找(循环）
 */
public class GetNumberOfK_Test3 {

    public int GetNumberOfK(int [] array , int k) {
        if (array.length == 0) return 0;
        if(array.length == 1 && k ==array[0]) return 1;
        if(array.length == 1 && k != array[0]) return 0;
        int start = GetFirstK(array,k,0,array.length - 1);
        int end = GetLastK(array,k,0,array.length - 1);
        return start == -1 ? 0 : (end - start + 1);
    }

    private int GetLastK(int[] array, int k, int start, int end) {
        if (start > end) return -1;
        int res = -1;
        while(start <= end){
            int mid = ( start + end ) >> 1;
            if(array[mid] > k) end = mid - 1;
            else if (array[mid] < k) start = mid + 1;
            else {
                res = mid;
                break;
            }
        }
        while (res + 1 < array.length && array[res + 1] == k) res++;
        return res;
    }

    private int GetFirstK(int[] array, int k, int start, int end) {
        if (start > end) return -1;
        int res = -1;
        while(start <= end){
            int mid = ( start + end ) >> 1;
            if(array[mid] > k) end = mid - 1;
            else if (array[mid] < k) start = mid + 1;
            else {
                res = mid;
                break;
            }
        }
        while (res - 1 >= 0 && array[res - 1] == k) res--;
        return res;
    }

    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,4,5,6,6,7,8,8,8,8,9,9,9,10};
        GetNumberOfK_Test3 test = new GetNumberOfK_Test3();
        System.out.println(test.GetNumberOfK(array,9));
    }

}
