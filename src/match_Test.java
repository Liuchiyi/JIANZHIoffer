import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class match_Test {

    public boolean match(char[] str, char[] pattern)
    {
        String stringS = new String(str);
        String patternS = new String(pattern);
        Pattern p = Pattern.compile(patternS);
        Matcher m = p.matcher(stringS);
        return m.matches();

    }

    public static void main(String[] args) {
        match_Test test = new match_Test();
        char [] pattern  = new char[]{'a','b','*','a'};
        char [] str  = new char[]{'a','a','a'};
        System.out.println(test.match(str,pattern));
    }

}
