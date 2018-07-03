/*
输入一个链表，输出该链表中倒数第k个结点。
* */

public class FindkNodeToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode pNode=head;
        ListNode nNode=head;
        for(int i=0;i<k;i++){
            if(pNode==null){
                return null;
            }
            pNode=pNode.next;
        }
        while(pNode!=null){
            pNode=pNode.next;
            nNode=nNode.next;
        }
        return nNode;
    }
}
