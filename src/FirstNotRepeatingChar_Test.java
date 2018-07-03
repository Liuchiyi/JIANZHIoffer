
import java.util.HashMap;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中
 * 找到第一个只出现一次的字符,并返回它的位置
 */

public class FirstNotRepeatingChar_Test {

    public int FirstNotRepeatingChar(String str) {
        int index = 0;
        if(str == null) return 0;
        if(str.length() == 0) return -1;
        if(str.length() == 1) return 1;
        HashMap map = new HashMap();
        for (int i = 0; i < str.length(); i++) {
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),1);
            }else{
                int value=(int)map.get(str.charAt(i));
                map.put(str.charAt(i),value + 1);
            }
        }
        for (int j = 0; j < str.length(); j++) {
            if((int)map.get(str.charAt(j)) == 1){
                index = j;
                break;
            }
        }
        return index ;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar_Test test = new FirstNotRepeatingChar_Test();
        System.out.println(test.FirstNotRepeatingChar(""));
    }

}
