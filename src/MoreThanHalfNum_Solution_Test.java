
/*
数组中有一个数字出现的次数超过数组长度的一半，
请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，
因此输出2。如果不存在则输出0。
*/

public class MoreThanHalfNum_Solution_Test {
    public static int MoreThanHalfNum_Solution(int[] array) {
        if(array.length==0) return 0;
        if (array.length==1) return array[0];
        mymerge_sort(array);
        if(array.length % 2==1) {
            for (int i = 0; i <= (array.length >> 1); i++) {
                if (array[i] == array[i + (array.length >> 1) ]) return array[i];
            }
        }else{
            for (int i = 0; i < (array.length >> 1); i++) {
                if (array[i] == array[i + (array.length >> 1) ]) return array[i];
            }
        }
        return 0;
    }

    private static void mymerge_sort(int[] array) {
        int len=array.length;
        int[] result=new int[len];
        mymerge_sort_recursive(array,result,0,len-1);
    }

    private static void mymerge_sort_recursive(int[] array, int[] result, int start, int end) {
        if(start>=end) return;
        int len=end-start, mid=(len>>1)+ start;
        int start1=start, end1=mid;
        int start2=mid+1,end2=end;
        mymerge_sort_recursive(array,result,start1,end1);
        mymerge_sort_recursive(array,result,start2,end2);
        int k=start;
        while(start1<=end1 && start2<=end2)
            result[k++] = array[start1] < array[start2] ? array[start1++] : array[start2++];
        while(start1<=end1)
            result[k++]=array[start1++];
        while(start2<=end2)
            result[k++]=array[start2++];
        for (k = start; k <=end; k++) {array[k]=result[k];}

    }

    public static void main(String[] args) {
        int[] arr = new int[] { 9, 2, 9, 9, 9, 9, 0, 2 };
        int res=MoreThanHalfNum_Solution(arr);
        System.out.println(res);

    }
}
