
/*
二叉搜索树与双向链表

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。
*/

import java.util.Stack;

public class Convert_Test2 {

    public static TreeNode Convert(TreeNode pRootOfTree) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode pNode= pRootOfTree;
        TreeNode curNode=null;
        TreeNode preNode=null;
        TreeNode resultNode=null;
        if(pNode==null) return null;
        while (pNode!=null||!stack.isEmpty()){
            if(pNode!=null){
                stack.push(pNode);
                pNode=pNode.left;
            }else {
                TreeNode node=stack.pop();
                if(preNode==null&&curNode==null){
                    resultNode=node;
                    preNode=node;
                }else{
                    curNode=node;
                    preNode.right=curNode;
                    curNode.left=preNode;
                    preNode=curNode;
                }
                pNode=node.right;
            }
        }
        return resultNode;
    }

    public static void main(String[] args) {
        TreeNode tree1=new TreeNode(7);
        TreeNode tree2=new TreeNode(3);
        TreeNode tree3=new TreeNode(10);
        TreeNode tree4=new TreeNode(2);
        TreeNode tree5=new TreeNode(4);
        TreeNode tree6=new TreeNode(9);
        TreeNode tree7=new TreeNode(12);
        TreeNode tree8=new TreeNode(1);
        TreeNode tree9=new TreeNode(8);
        TreeNode tree10=new TreeNode(11);
        TreeNode tree11=new TreeNode(13);
        TreeNode tree12=new TreeNode(5);
        tree1.left=tree2;
        tree1.right=tree3;
        tree2.left=tree4;
        tree2.right=tree5;
        tree3.left=tree6;
        tree3.right=tree7;
        tree4.left=tree8;
        tree6.left=tree9;
        tree7.left=tree10;
        tree7.right=tree11;
        tree5.right=tree12;
       TreeNode convert = Convert(tree1);
        System.out.println(convert.val);
    }
}
