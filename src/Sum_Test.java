/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 短路原理，递归
 */


public class Sum_Test {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag =(sum > 0) && ((sum += Sum_Solution(n-1))>0);
        return sum;
    }

    public static void main(String[] args) {
        Sum_Test test = new Sum_Test();
        System.out.println(test.Sum_Solution(3));
    }
}
