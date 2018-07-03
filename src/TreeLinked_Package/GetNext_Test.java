package TreeLinked_Package;

/**
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

public class GetNext_Test {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode.left == null && pNode.right == null && pNode.next == null) return null;
        if(pNode.left == null && pNode.right == null && pNode == pNode.next.left) return pNode.next;
        if(pNode.left == null && pNode.right == null && pNode == pNode.next.right) {
            if(pNode.next.next == null) return null;
            else {
               return upSearch(pNode.next);
            }
        }
        if(pNode.right == null) return upSearch(pNode);
        else return downSearch(pNode.right);

    }
     private TreeLinkNode upSearch(TreeLinkNode curNode){
         while(curNode.next !=null && curNode != curNode.next.left){
             curNode = curNode.next;
         }
         return curNode.next;
     }
     private  TreeLinkNode downSearch(TreeLinkNode curNode){
        while (curNode.left != null){
            curNode = curNode.left;
        }
        return curNode;
     }
}
