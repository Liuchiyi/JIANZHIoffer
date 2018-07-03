import java.util.ArrayList;
import java.util.Collections;
/*
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的
所有字符串abc,acb,bac,bca,cab和cba。

输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
*/

public class Permutation_Test {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> resultList=new ArrayList<>();
        if(str.length()==0) return resultList;
        if(str.length()>=1){
            PermutationHelper(0,str.toCharArray(),resultList);
            Collections.sort(resultList);
        }
        return resultList;
    }

    private void PermutationHelper(int begin, char[] str, ArrayList<String> resultList) {
        if(begin==str.length-1){
            String val=String.valueOf(str);
            resultList.add(val);
        }else{
            for (int j = begin; j < str.length; j++) {
                if(j!=begin&&str[j]==str[begin]) continue;
                swap(j,begin,str);
                PermutationHelper(begin+1,str,resultList);
                swap(j,begin,str);
            }
        }

    }

    private void swap(int a, int b, char[] str) {
        char temp=str[a];
        str[a]=str[b];
        str[b]=temp;
    }

    public static void main(String[] args) {
        Permutation_Test p = new Permutation_Test();
        System.out.println(p.Permutation("abc").toString());
    }


}
