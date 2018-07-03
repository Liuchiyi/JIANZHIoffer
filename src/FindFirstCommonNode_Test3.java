
/**
 * 输入两个链表，找出它们的第一个公共结点。
 */

public class FindFirstCommonNode_Test3 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        int num_p1 = 0;
        int num_p2 = 0;
        ListNode cur1 = pHead1, cur2 = pHead2;
        while (pHead1 != null){
            num_p1++;
            pHead1 = pHead1.next;
        }
        while (pHead2 != null){
            num_p2++;
            pHead2 = pHead2.next;
        }
        if(num_p1 > num_p2){
            for (int i = 0; i < num_p1 - num_p2; i++) {
                cur1 = cur1.next;
            }
        }else if(num_p1 < num_p2) {
            for (int i = 0; i < num_p2 - num_p1; i++) {
                cur2 = cur2.next;
            }
        }
        while(cur1 != null && cur2 != null){
            if(cur1 == cur2) return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
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
        FindFirstCommonNode_Test3 test = new FindFirstCommonNode_Test3();
        System.out.println(test.FindFirstCommonNode(listnode1,listnode5).val);

    }
}
