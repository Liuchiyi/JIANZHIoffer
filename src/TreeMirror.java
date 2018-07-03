

public class TreeMirror {

/*
	操作给定的二叉树，将其变换为源二叉树的镜像。
	输入描述:

	二叉树的镜像定义：源二叉树
    	    8
					/  \
					6   10
					/ \  / \
					5  7 9 11
	镜像二叉树
    	    8
					/  \
					10   6
					/ \  / \
					11 9 7  5

*/


	public static void Mirror(TreeNode root) {
        if(root==null)return;
        if(root.left==null&&root.right==null)return;
        TreeNode saveNode=root.left;
        root.left=root.right;
        root.right=saveNode;
        Mirror(root.left);
        Mirror(root.right);
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
    	tree1.left=tree2;
    	tree1.right=tree3;
    	tree2.left=tree4;
    	tree2.right=tree5;
    	tree3.right=tree6;
    	tree4.left=tree7;
    	tree5.left=tree8;
    	tree5.right=tree9;
    	tree6.right=tree10;
    	Mirror(tree1);
    	System.out.println(tree1.left.val);
	}
}
