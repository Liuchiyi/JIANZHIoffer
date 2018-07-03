

/**
 * 一个整型数组里除了两个数字之外，
 * 其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */

public class FindNumsAppearOnce_Test2 {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length == 0 || array.length == 1 || array.length == 2) return;
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            temp = temp ^ array[i];
        }
        int bits = 1;
        while ((bits & temp )== 0) bits = bits << 1;
        num1[0] = num2[0] =0;
        for (int i = 0; i < array.length; i++) {
            if((array[i] & bits) == 0) num1[0] = num1[0] ^ array[i];
            if((array[i] & bits) != 0) num2[0] = num2[0] ^ array[i];
        }
    }

    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,4,5,6,7,8,7,6,5,4,3,2};
        int num1[] = new int[1];
        int num2[] = new  int[1];
        FindNumsAppearOnce_Test2 test = new FindNumsAppearOnce_Test2();
        test.FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

}
