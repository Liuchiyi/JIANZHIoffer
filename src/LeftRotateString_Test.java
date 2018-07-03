/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */

public class LeftRotateString_Test {

    public String LeftRotateString(String str,int n) {
        StringBuffer sb = new StringBuffer(str);
        if(str.length() == 0)return "";
        while (n > str.length()) n = n - str.length();
        sb.append(sb.substring(0, n ));
        sb.delete(0,n);
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = new String("");
        LeftRotateString_Test test = new LeftRotateString_Test();
        System.out.println();
        System.out.println(test.LeftRotateString(str,4));
    }

}
