import java.util.Stack;

public class Stack2ToList {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public  void push(int node) {
            stack1.push(node);
    }
    
    public int pop() {
        int result=0;
        if(stack1.size()==0){
            return result;
            }
        while(stack1.size()>0){
             stack2.push(stack1.pop());
        }
        result=stack2.pop();
        while(stack2.size()>0){
            stack1.push(stack2.pop());
        }
        return result;
    }
    public static void main(String[] args)  {
    	Stack2ToList stack2ToList=new Stack2ToList();
		stack2ToList.push(1);
		stack2ToList.push(2);
		stack2ToList.push(3);
		System.out.println(stack2ToList.pop());
		System.out.println(stack2ToList.pop());
		stack2ToList.push(4);
		System.out.println(stack2ToList.pop());
		stack2ToList.push(5);
		System.out.println(stack2ToList.pop());
		System.out.println(stack2ToList.pop());
	}
}
