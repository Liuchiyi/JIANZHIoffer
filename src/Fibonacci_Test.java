
/*
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
        n<=39
*/

public class Fibonacci_Test {

    public int Fibonacci(int n) {
        if(n>39||n<0){
            throw new RuntimeException("超出范围");
        }else if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            int [] result =new int [n+1];
            result[0]=0;
            result[1]=1;
            for(int i=2;i<=n;i++){
                result[i]=result[i-1]+result[i-2];
            }
            return result[n];
        }
    }
}
