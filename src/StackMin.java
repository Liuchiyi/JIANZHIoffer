import java.util.Stack;

public class StackMin {
    Stack<Integer> stack=new Stack<Integer>();

    public void push(int node) {
        stack.push(node);

    }

    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        if(!stack.isEmpty())
            return stack.peek();
        else throw new RuntimeException("为空栈,栈顶无元素");

    }

    public int min() {
        if(stack.isEmpty()) throw new RuntimeException("为空栈,无最小值");
        int min=stack.peek();
        int []current=new int[stack.size()];
        int i=0;
        while(!stack.isEmpty()){
            current[i]=stack.pop();
            if(min>current[i]){
                min=current[i];
            }
            i++;
        }
        for (int j = i; j >0 ; j--) {
            stack.push(current[j-1]);
        }
        return min;
    }

    public static void main(String[] args) {
        StackMin test=new StackMin();
        test.push(2);
        int a =test.min();
        test.push(3);
        System.out.println(test.min());
        test.push(4);

        test.push(1);
        System.out.println(test.min());
        test.pop();
        System.out.println(test.min());
//        test.push(6);
//        test.push(8);
//        test.push(10);
//        test.push(5);
    }
}
