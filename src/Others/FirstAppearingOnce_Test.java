package Others;


public class FirstAppearingOnce_Test {
    int [] result = new int[256];
    int index = 0;
    {
        for (int i = 0; i < 256; i++) {
            result[i] = -1;
        }
    }
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(result[ch] == -1) {
            result[ch] = index;
            index++;
        }else if(result[ch] >= 0)
            result[ch] = -2;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int min = -1;
        int res = '#';
        for (int i = 0; i < 256; i++) {
            if(min == -1 && result[i] >=0){
                min = result[i];
                res = i;
            }

            if(result[i]>=0 && min > result[i]){
                min = result[i];
                res = i;
            }
        }
        return (char)res;
    }

    public static void main(String[] args) {
        FirstAppearingOnce_Test test = new FirstAppearingOnce_Test();
        test.Insert('a');
        test.Insert('b');
        test.Insert('r');
        test.Insert('r');
        test.Insert('a');
        System.out.println(test.FirstAppearingOnce());
        test.Insert('b');
        test.Insert('t');
        test.Insert('t');
        System.out.println(test.FirstAppearingOnce());


    }
}
