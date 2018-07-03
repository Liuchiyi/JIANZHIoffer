import java.util.Stack;
/*
输入一个链表，反转链表后，输出链表的所有元素。
*/

public class ReversList {

	public static void main(String[] args) {
        
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		ListNode mNode=head.next;
		mNode.next=new ListNode(3);
		mNode=mNode.next;
		mNode.next=new ListNode(4);
		if(head==null){
            System.out.println(11111);
        }
        if(head.next==null){
            System.out.println(head.val);
        }
        Stack<ListNode> stack=new Stack<ListNode>();
        stack.push(head);
        ListNode pNode=head.next;
        while(pNode!=null){
            stack.push(pNode);
            pNode=pNode.next;
        }
        ListNode resultNode=stack.pop();
        pNode=resultNode;
        while(!stack.isEmpty()){
            pNode.next=stack.pop();
            pNode=pNode.next;
        }
        pNode.next=null;
        
	}
}
