/*
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
则打印出这三个数字能排成的最小数字为321323。
*/

import java.util.Arrays;

public class PrintMinNumber_Test {
    public String PrintMinNumber(int [] numbers) {
        String [] list = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            list[i]=Integer.toString(numbers[i]);
        }
        Arrays.sort(list, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        String result = "";
        for (int j = 0; j < list.length; j++) {
            result += list[j];
        }
        return result;
    }

    public static void main(String[] args) {
        PrintMinNumber_Test test = new PrintMinNumber_Test();
        int [] num = new int[]{1};
        System.out.println(test.PrintMinNumber(num));
    }
}
