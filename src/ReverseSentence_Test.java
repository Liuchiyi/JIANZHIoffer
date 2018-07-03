/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 *
 */

public class ReverseSentence_Test {

    public String ReverseSentence(String str) {
        int len = str.length();
        if(len == 0 || len == 1) return str;
        int beginNum = 0;
        int endNum = -1;
        StringBuffer sb = new StringBuffer(str);
        for (int i = 0; i < len; i++) {
            if(sb.charAt(i) == ' '){
                beginNum = endNum + 1;
                endNum = i;
                sb.insert(len, sb.substring(beginNum,endNum + 1));
            }
        }
        sb.insert(len,' ');
        return sb.substring(endNum + 1, endNum + len + 1).toString();
    }

    public static void main(String[] args) {
        String str = "student. a am I";
        ReverseSentence_Test test = new ReverseSentence_Test();
        System.out.println(test.ReverseSentence(str));
    }

}
