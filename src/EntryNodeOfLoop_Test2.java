
/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */

public class EntryNodeOfLoop_Test2 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null || pHead.next.next == null) return null;
        ListNode oneNode = pHead.next;
        ListNode twoNode = pHead.next.next;
        while (oneNode != twoNode){
            oneNode = oneNode.next;
            twoNode = twoNode.next.next;
        }
        twoNode = pHead;
        while (oneNode != twoNode){
            oneNode = oneNode.next;
            twoNode = twoNode.next;
        }
        return oneNode;
    }
}
