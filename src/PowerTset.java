
/*
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
*/

public class PowerTset {
	public static void main(String[] args) {
		double base=1.1;
		int exponent=0;
        int numOfbit=0;
        double result=1;
        double result2=0;
        if(exponent>0){
            numOfbit=exponent;
        }else if(exponent==0){
            System.out.println(1);
        }else{
            if(base==0){
                throw new RuntimeException("��Ч����");
            }
            numOfbit=-exponent;
        }
        while(numOfbit!=0){
            if((numOfbit&1)==1){
                result*=base;
            }
            base*=base;
            numOfbit>>=1;
        }
        result2=exponent>0?result:(1/result);
        System.out.println(result2); 
	}
}
