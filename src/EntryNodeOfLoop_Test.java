import java.util.HashSet;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */

public class EntryNodeOfLoop_Test {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null) return null;
        HashSet<Integer> set = new HashSet<>();
        ListNode curNode = pHead;
        while (curNode != null){
            if(set.add(curNode.val)) curNode = curNode.next;
            else return curNode;
        }
        return null;
    }
}
