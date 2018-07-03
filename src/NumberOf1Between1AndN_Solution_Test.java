/*
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
但是对于后面问题他就没辙了。
ACMer希望你们帮帮他,并把问题更加普遍化,
可以很快的求出任意非负整数区间中1出现的次数。
*/

public class NumberOf1Between1AndN_Solution_Test {

    public int NumberOf1Between1AndN_Solution(int n) {
        int num = 0; //个数
        int cur = n;  //当前数
        int bit = 10;  //记录当前的位数
        int count = 0;  //该位数下的1的个数(整的)
        int remainder,quotient; //余数和商
        while(cur!= 0){
            remainder = cur % 10;
            quotient =cur / 10;
            num = num + remainder * count;  //首先加上该位数前整的1的个数 如1-9 为1个,1-99为20个,1-199为20*100+100个
            if(remainder > 1){   //如果余数大于1,则加上整数个1的个数,如当前位为十位,余数是2,则十位为1的数加上,则加上10.
                                // 如果为百位,余数是2,则加上100
                num = num + bit / 10;
            }else if (remainder == 1){  //如果余数为1,则1出现的次数就是原来的数除以该位+1(零也在其中) 如122计算到百位,则加上22+1
                num = num + n % (bit / 10) + 1;
            }
            count = count * 10 + bit / 10; //该位数前整的1的个数 如1-9 为1个,1-99为20个,1-199为20*100+100个
            bit = bit * 10;  //位数前移
            cur = quotient;
        }
        return num;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution_Test test = new NumberOf1Between1AndN_Solution_Test();
        System.out.println(test.NumberOf1Between1AndN_Solution(10000));
    }
}
