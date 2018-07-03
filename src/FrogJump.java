
/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
*/

public class FrogJump {
	public static int JumpFloor(int target){
		if(target<=0){
			throw new RuntimeException("������������̨����");
		}
		int numOfOne=0;
		int numOfTwo=0;
		int result=0;
		for(int i=0;i<=target/2;i++){
			long numerator=1L;//����
			long denominator=1L;//��ĸ
			numOfTwo=i;
			numOfOne=target-2*numOfTwo;
			if(numOfOne<0){
				break;
			}else if(numOfOne==0){
				result=result+1;
			}else if(numOfOne<=numOfTwo){
				for(int x=numOfOne+numOfTwo;x>=numOfTwo+1;x--){
					numerator=numerator*x;
				}
				for(int y=numOfOne;y>1;y--){
					denominator=denominator*y;
				}
				result=result+(int)(numerator/denominator);
			}else{
				for(int x=numOfOne+numOfTwo;x>=numOfOne+1;x--){
					numerator=numerator*x;
				}
				for(int y=numOfTwo;y>1;y--){
					denominator=denominator*y;
				}
				result=result+(int)(numerator/denominator);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(JumpFloor(29));
	}
}
