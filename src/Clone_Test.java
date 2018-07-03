public class Clone_Test {

    /*
    输入一个复杂链表（每个节点中有节点值，
    以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
    返回结果为复制后复杂链表的head。
    （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
    */

    public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null) return pHead;
        RandomListNode Head=new RandomListNode(pHead.label);
        RandomListNode ppNode=pHead.next;
        RandomListNode pNode=Head;
        while(ppNode!=null){
            pNode.next=new RandomListNode(ppNode.label);
            ppNode=ppNode.next;
            pNode=pNode.next;
        }
        RandomListNode rpNode=pHead;
        RandomListNode rNode=Head;
        while(rpNode!=null){
            if(rpNode.random!=null){
                RandomListNode r_currentNode=Head;
                while(rpNode.random.label!=r_currentNode.label){
                    r_currentNode=r_currentNode.next;
                }
                rNode.random=r_currentNode;
            }
            rpNode=rpNode.next;
            rNode=rNode.next;
        }
        return Head;
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
