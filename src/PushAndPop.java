import java.util.ArrayList;

public class PushAndPop {

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        int length=pushA.length;
        int min;
        int current;
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(pushA[j]==popA[i]){
                    list.add(j);
                    break;
                }
            }
        }
        if(list.size()!=length) return false;
        min=list.get(0);
        for(int m=1;m<length;m++){
            current=list.get(m);
            if((current-min)<-1) return false;
            if(current<min){
                min=current;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int [] pushA={1,2,3,4,5};
        int [] popA={6,1,2,3,5};
        System.out.println(IsPopOrder(pushA,popA));
    }
}
