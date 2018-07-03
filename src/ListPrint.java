import java.util.ArrayList;
public class ListPrint{

/*
    输入一个链表，从尾到头打印链表每个节点的值。
*/

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode==null){
            return new ArrayList<Integer>();
        }
        int length=1;
        ListNode listNode_l=listNode;//�󳤶�
        ArrayList<Integer> list_old=new ArrayList<Integer>();
        list_old.add(listNode_l.val);
        while(listNode_l.next!=null){
            length++;
            listNode_l=listNode_l.next;
            list_old.add(listNode_l.val);
            
        }
        ArrayList<Integer> list_new=new ArrayList<Integer>(length);
        for(int i=0;i<length;i++){
        	list_new.add(list_old.get(length-1-i));
        }
        return list_new;       
    }
    public static void main(String[] args) {
    	ListNode listnode=new ListNode(67);
    	ListNode listnode2=new ListNode(20);
    	ListNode listnode3=new ListNode(0);
    	ListNode listnode4=new ListNode(30);
    	listnode.next=listnode2;
    	listnode2.next=listnode3;
    	listnode3.next=listnode4;
    	ArrayList<Integer> list2=new ArrayList<Integer>();
    	list2=printListFromTailToHead(listnode);
	}
}