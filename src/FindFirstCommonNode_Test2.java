import java.util.HashSet;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */

public class FindFirstCommonNode_Test2 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        HashSet<ListNode> hashSet = new HashSet();
        while(pHead1 != null){
            hashSet.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null){
           if(hashSet.contains(pHead2)) return pHead2;
           pHead2 = pHead2.next;
        }
        return null;
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
        FindFirstCommonNode_Test2 test = new FindFirstCommonNode_Test2();
        System.out.println(test.FindFirstCommonNode(listnode1,listnode5).val);

    }
}
