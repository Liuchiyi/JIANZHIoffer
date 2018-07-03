import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */

public class FindFirstCommonNode_Test {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode curNode;
        curNode = pHead1;
        while(curNode != null){
            stack1.push(curNode);
            curNode = curNode.next;
        }
        curNode = pHead2;
        while (curNode != null){
            stack2.push(curNode);
            curNode = curNode.next;
        }
        ListNode resNode = null;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            if(stack1.peek().val != stack2.peek().val) break;
            resNode = stack1.pop();
            stack2.pop();
        }
        if(resNode != null) resNode.next = null;
        return  resNode;
    }

    public static void main(String[] args) {
        ListNode listnode1 = new ListNode(1);
        ListNode listnode2 = new ListNode(2);
        ListNode listnode3 = new ListNode(3);
        ListNode listnode4 = new ListNode(4);
        ListNode listnode5 = new ListNode(5);
        ListNode listnode6 = new ListNode(6);
        ListNode listnode7 = new ListNode(7);
        ListNode listnode8 = new ListNode(8);
        listnode1.next = listnode2;
        listnode2.next = listnode3;
        listnode3.next = listnode4;
        listnode5.next = listnode6;
        listnode6.next = listnode7;
        listnode7.next = listnode3;
        FindFirstCommonNode_Test test = new FindFirstCommonNode_Test();
        System.out.println(test.FindFirstCommonNode(listnode1,listnode5).val);

    }
}
