/*
数组中有一个数字出现的次数超过数组长度的一半，
请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，
因此输出2。如果不存在则输出0。
*/
public class MoreThanHalfNum_Solution_Test2 {
    public static int MoreThanHalfNum_Solution(int[] array) {
        if(array.length == 0) return 0;
        if(array.length == 1) return array[0];
        int result = array[0];
        int count = 1;
        for (int i = 1; i <array.length; i++) {
            if(count == 0){
                result = array[i];
            }
            if(result == array[i]){
                count ++;
            }else {
                count --;
            }
        }
        if(count==0) return 0;
        int times=0;
        for (int i = 0; i < array.length; i++) {
            if(result == array[i]) times ++;
        }
        if(times >array.length/2){
            return result;
        }else {
            return 0;
        }
    }



    public static void main(String[] args) {
        int[] arr = new int[] { 9 ,7 };
        int res=MoreThanHalfNum_Solution(arr);
        System.out.println(res);

    }
}
