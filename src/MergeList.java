
/*
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
*/

public class MergeList {

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null&&list2==null){
            return null;
        }
        if(list1==null&&list2!=null){
            return list2;
        }
        if(list1!=null&&list2==null){
            return list1;
        }
        ListNode result=null;
        if(list1.val>list2.val){
            result=list2;
            list2=list2.next;
            result.next=Merge(list1,list2);
        }else{
            result=list1;
            list1=list1.next;
            result.next=Merge(list1,list2);
        }
        return result;
    }
    
    public static void main(String[] args) {
    	ListNode list1=new ListNode(1);
    	ListNode list11=new ListNode(3);
    	ListNode list12=new ListNode(5);
    	ListNode list2=new ListNode(2);
    	ListNode list21=new ListNode(4);
    	ListNode list22=new ListNode(6);
    	list1.next=list11;
    	list11.next=list12;
    	list2.next=list21;
    	list21.next=list22;
    	ListNode result1=Merge(list1,list2);
    	System.out.println(result1.next.val);
	}
}
