/*
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
*/

public class Binary {
	public static void main(String[] args) {
        int flag=1;
        int result=0;
        int n=666;
        System.out.println(Integer.toBinaryString(n));
        while(flag!=0){
            if((flag & n)!=0){
                result++;
            }
        flag=flag<<1;
        }
        System.out.println(result);
	}
}
