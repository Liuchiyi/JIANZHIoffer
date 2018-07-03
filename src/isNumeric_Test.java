/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class isNumeric_Test {

    public boolean isNumeric(char[] str) {
        int len = str.length;
        boolean flag = false;
        if(str.length == 0) return false;
        int index = 0;
        if(str[0] == '+'||str[0] == '-') index++;
        if(index == len) return false;
        if(str[index] == 'e' || str[index] == 'E' ||str[index] == '.') return false;
        if(str[index] == '0') {
            index++;
            flag = true;
        }
        if(index == len) return true;
        for (; index < len; index++) {
            if(str[index] >='0' && str[index] <= '9' ) continue;
            else break;
        }
        if(index == len){
            if(!flag) return true;
            else return false;
        }
        if(str[index] == '.'){
            index ++;
            if(index == len) return false;
            if(str[index] == 'e' ||str[index] == 'E') return false;
            for (; index < len; index++) {
                if(str[index] == 'e' ||str[index] == 'E') break;
                if(str[index] <'0' || str[index] > '9' ) return false;
            }
            if(index == len) return true;
        }
        if(str[index] == 'e' ||str[index] == 'E'){
            index++;
            if(index == len) return false;
            if(str[index] == '+'||str[index] == '-') index++;
            if(index == len) return false;
            if(str[index] == '0')return false;
            for (; index < len; index++) {
                if(str[index] <'0' || str[index] > '9' ) return false;
            }
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        char [] str  = new char[]{'3','.','4','5'};
        isNumeric_Test test = new isNumeric_Test();
        System.out.println(test.isNumeric(str));
    }

}
