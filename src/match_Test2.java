
public class match_Test2 {

    public boolean match(char[] str, char[] pattern)
    {
        if(pattern.length == 0){
            if(str.length == 0)return true;
            else return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchHelper(str,strIndex,pattern,patternIndex);
    }

    private boolean matchHelper(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if(str.length == strIndex && pattern.length == patternIndex) return true;
        if(patternIndex == pattern.length && strIndex != str.length)return false;
        if(patternIndex + 1 <pattern.length && pattern[patternIndex+1] == '*'){
            if((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (strIndex != str.length && pattern[patternIndex] == '.')){
                return matchHelper(str,strIndex,pattern,patternIndex+2)
                        ||matchHelper(str,strIndex+1,pattern,patternIndex+2)
                        ||matchHelper(str,strIndex+1,pattern,patternIndex);
            }else {
                return matchHelper(str,strIndex,pattern,patternIndex + 2);
            }
        }else {
            if( (strIndex != str.length  && pattern[patternIndex] == str[strIndex]) || (strIndex != str.length  &&pattern[patternIndex] == '.'))
                return matchHelper(str,strIndex + 1,pattern,patternIndex + 1);
            else return false;
        }
    }

    public static void main(String[] args) {
        match_Test2 test = new match_Test2();
        char [] pattern  = new char[]{'.','*','a','*','a'};
        char [] str  = new char[]{'b','c','b','b','a','b','a','b'};
        System.out.println(test.match(str,pattern));
    }

}
