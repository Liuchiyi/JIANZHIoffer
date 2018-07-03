import java.util.Stack;

public class PushAndPop2 {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if(pushA.length==0) return false;
        Stack<Integer> stack=new Stack<Integer>();
        int currentPop=0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while((!stack.isEmpty())&&stack.peek()==popA[currentPop]&&currentPop<popA.length){
                stack.pop();
                currentPop++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int [] pushA={1,2,3,4,5};
        int [] popA={4,2,1,3,5};
        System.out.println(IsPopOrder(pushA,popA));
    }
}
