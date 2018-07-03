
/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
*/



import java.util.ArrayList;
import java.util.LinkedList;

public class PrintFromTopToBottom_Test {

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null) return list;
        LinkedList<TreeNode> linkedList=new LinkedList<>();
        linkedList.add(root);
        TreeNode pNode;
        while(!linkedList.isEmpty()){
            pNode=linkedList.remove();
            list.add(pNode.val);
            if(pNode.left!=null){
                linkedList.add(pNode.left);
            }
            if(pNode.right!=null){
                linkedList.add(pNode.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node0=null;
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
//        node1.left=node2;
//        node1.right=node3;
//        node2.left=node4;
//        node2.right=node5;
//        node3.left=node6;
//        node3.right=node7;
        node1.right=node2;
        node2.right=node3;
        node3.right=node4;
        node4.right=node5;
        node5.right=node6;
        node5.left=node7;



        ArrayList result=PrintFromTopToBottom(node1);


    }
}
