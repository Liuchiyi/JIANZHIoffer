import java.util.Stack;
/*
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
*/
public class StackMin2 {
    Stack<Integer> stack=new Stack<Integer>();//主栈
    Stack<Integer> stackHelp=new Stack<Integer>();//辅助栈
    public void push(int node) {
    stack.push(node);
    if(stackHelp.isEmpty()) {
        stackHelp.push(node);
    }
    else{
        if(node<=stackHelp.peek()){
            stackHelp.push(node);
        }
    }
    }

    public void pop() {
        if(!stack.isEmpty()){
            if(stack.pop()==stackHelp.peek()){
                stackHelp.pop();
            }
        }else{
            throw new RuntimeException("为空栈");
        }
    }

    public int top() {
        if(stack.isEmpty()){
            throw new RuntimeException("为空栈");
        }else{
            return stack.peek();
        }
    }

    public int min() {
        if(!stackHelp.isEmpty()) {
            return stackHelp.peek();
        }else throw new RuntimeException("为空栈");
    }

    public static void main(String[] args) {
        StackMin2 test=new StackMin2();
        test.push(3);
        test.push(2);
        System.out.println(test.min());
        test.push(4);
        test.push(1);

        test.push(0);
        System.out.println(test.min());
        test.pop();
        System.out.println(test.min());
        test.pop();
        System.out.println(test.min());
        test.pop();
        System.out.println(test.min());
        test.pop();
        System.out.println(test.min());
        test.pop();
        System.out.println(test.min());

    }
}
