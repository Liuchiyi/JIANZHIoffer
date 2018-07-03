
/**
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class deleteDuplication_Test2 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null) return null;
        if(pHead.next != null && pHead.val ==pHead.next.val){
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val){
                pNode = pNode.next;
            }
            return deleteDuplication(pNode);
        }
        else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        deleteDuplication_Test2 test = new deleteDuplication_Test2();
        ListNode result=test.deleteDuplication(node1);
        System.out.println(result.next.val);
    }
}
