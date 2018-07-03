/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 常规做法，由上往下遍历判断
 */

public class IsBalanced_Test {

    public boolean IsBalanced_Solution(TreeNode root) {
        boolean flag = true;
        if(root == null) return true;
        if(!IsBalanced_Solution(root.left)) flag = false;
        if(!IsBalanced_Solution(root.right)) flag = false;
        if(TreeDepth(root.left) - TreeDepth(root.right) > 1 || TreeDepth(root.left) - TreeDepth(root.right) < -1) flag = false;
        return flag;
    }

    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        int count_left = 1;
        int count_right = 1;
        count_left += TreeDepth(root.left);
        count_right += TreeDepth(root.right);
        return count_left > count_right ? count_left : count_right;
    }

    public static void main(String[] args) {
        IsBalanced_Test test = new IsBalanced_Test();
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
        tree1.right=tree3;
        tree2.left=tree4;
        tree2.right=tree5;
        System.out.println(test.IsBalanced_Solution(tree11));
    }
}
