public class Clone_Test2 {

    /*
    输入一个复杂链表（每个节点中有节点值，
    以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
    返回结果为复制后复杂链表的head。
    （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
    */

    public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null) return null;
        RandomListNode pNode=pHead;
        while(pNode!=null){
            RandomListNode exchange=pNode.next;
            pNode.next=new RandomListNode(pNode.label);
            pNode.next.next=exchange;
            pNode=exchange;
        }
        pNode=pHead;
        while(pNode!=null){
            if(pNode.random!=null){
                pNode.next.random=pNode.random.next;
            }
            pNode=pNode.next.next;
        }
        RandomListNode head=pHead.next;
        pNode=pHead;
        while(pNode!=null){
            RandomListNode copyNode=pNode.next;
            pNode.next=pNode.next.next;
            if(pNode.next!=null)copyNode.next=pNode.next.next;
            else copyNode.next=null;
            pNode=pNode.next;
        }
        return head;

    }

    public static void main(String[] args) {
        RandomListNode pHead=new RandomListNode(1);
        RandomListNode node2=new RandomListNode(2);
        RandomListNode node3=new RandomListNode(3);
        RandomListNode node4=new RandomListNode(4);
        RandomListNode node5=new RandomListNode(5);
        pHead.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.random=node2;
        node3.random=node3;
        RandomListNode result=Clone(pHead);
        System.out.println(result.next.next.random.label);

    }
}
