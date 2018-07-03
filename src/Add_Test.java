
/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

public class Add_Test {
    public int Add(int num1,int num2) {
        while((num1 & num2) != 0){
            int n1 = num1 & num2;
            int n2 = num1 ^ num2;
            num1 = n1<<1;
            num2 = n2;
        }
        return num1 ^ num2;
    }

    public static void main(String[] args)  {
        Add_Test test = new Add_Test();
       System.out.println(test.Add(322,657));
    }
}
