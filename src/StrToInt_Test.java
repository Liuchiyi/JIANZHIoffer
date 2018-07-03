public class StrToInt_Test {
    public int StrToInt(String str) {
        if(str == null || str.trim().length() == 0)return 0;
        int bit = str.length();
        boolean flag = true;
        int sum = 0;
        if(str.charAt(0) == '+' ){
            flag = true;
        }else if(str.charAt(0) == '-'){
            flag = false;
        }else if('0' <= str.charAt(0) && str.charAt(0) <= '9'){
            sum += (str.charAt(0) - '0')*((int)Math.pow(10,bit-1));
        }else return 0;
        for (int i = 1; i < bit; i++) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9') return 0;
        }
        for (int i = 1; i < bit; i++) {
            sum += (str.charAt(i) - '0')*((int)Math.pow(10,bit-i-1));
        }
        return flag? sum :-sum;
    }
    public static void main(String[] args) {
        StrToInt_Test test = new StrToInt_Test();
        System.out.println(test.StrToInt("111"));
    }
}
