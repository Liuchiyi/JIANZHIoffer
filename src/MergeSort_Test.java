
//归并排序

public class MergeSort_Test {
    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, len - 1);
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 1, 1, 9, 2, 0, 2 };
        long startTime = System.currentTimeMillis(); // 获取开始时间
        merge_sort(arr);
        long endTime = System.currentTimeMillis(); // 获取开始时间
        System.out.println("执行时间：" + (endTime - startTime));
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
