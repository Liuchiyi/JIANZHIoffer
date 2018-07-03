import java.util.LinkedList;


/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *
 * 非递归写法（层次遍历）
 */

public class TreeDepth_Test2 {
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        TreeNode pNode;
        int depth = 0 , curCount = 0 , depthCount = 1;
        while(!list.isEmpty()){
            curCount++;
            pNode = list.pop();
            if(pNode.left != null) list.add(pNode.left);
            if(pNode.right != null) list.add(pNode.right);
            if(curCount == depthCount){
                depth++;
                depthCount = list.size();
                curCount = 0;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode tree1=new TreeNode(1);
        TreeNode tree2=new TreeNode(2);
        TreeNode tree3=new TreeNode(3);
        TreeNode tree4=new TreeNode(4);
        TreeNode tree5=new TreeNode(5);
        TreeNode tree6=new TreeNode(6);
        TreeNode tree7=new TreeNode(7);
        TreeNode tree8=new TreeNode(8);
        TreeNode tree9=new TreeNode(9);
        TreeNode tree10=new TreeNode(10);
        tree1.right=tree2;
        tree2.right=tree3;
        tree3.right=tree4;
        tree4.right=tree5;
        TreeDepth_Test2 test = new TreeDepth_Test2();
        System.out.println(test.TreeDepth(tree1));
    }
}
