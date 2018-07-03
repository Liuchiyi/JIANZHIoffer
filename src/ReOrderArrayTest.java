import java.util.Stack;

/*
		输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
		使得所有的奇数位于数组的前半部分，
		所有的偶数位于位于数组的后半部分，并保证奇数和奇数，
		偶数和偶数之间的相对位置不变。
*/
public class ReOrderArrayTest {
	public static void main(String[] args) {
		int[] array=new int[]{1,2,3,4,5,6,7,8,9,10};
		System.out.println(array.length);
		int[] frontArray=new int[array.length];
		int[] backArray=new int[array.length];
		int f_i=0;
		int b_i=0;
		for(int i=0;i<array.length;i++){
			if(array[i]%2==1){
				frontArray[f_i]=array[i];
				f_i++;
			}else{
				backArray[b_i]=array[i];
				b_i++;
			}
		}
        for(int m=0;m<f_i;m++){
            array[m]=frontArray[m];
        }
		for(int n=0;n<b_i;n++){
			array[f_i+n]=backArray[n];
		}
		System.out.println(array[8]);
		Stack<Integer> stack=new Stack<Integer>();
		
	}
}
