/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 改进做法：由下往上遍历判断（后序遍历）
 */

public class IsBalanced_Test2 {

    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if(root == null) return 0;
        int left = getDepth(root.left);
        if(left == -1) return -1;
        int right = getDepth(root.right);
        if(right == -1) return -1;
        if(Math.abs(left - right) < 2) return Math.max(left,right) + 1;
        else return -1;
    }


    public static void main(String[] args) {
        IsBalanced_Test2 test = new IsBalanced_Test2();
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
        TreeNode tree11 = null;
        tree1.left=tree2;
        tree2.right=tree3;
        tree3.left=tree4;
        tree4.right=tree5;
        System.out.println(test.IsBalanced_Solution(tree1));
    }
}
