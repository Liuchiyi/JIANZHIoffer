/*

输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

*/


public class HasSubTree_Test {
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result=false;
    	if(root2==null||root1==null){
            return false;
        }
        if(prepare(root1,root2)) result=true;
        if(HasSubtree(root1.left,root2)) result=true;
        if(HasSubtree(root1.right,root2)) result= true;
        return result;
    }
    
    public static boolean prepare(TreeNode root1,TreeNode root2){
    	if(root1==null&&root2!=null)return false;
    	if(root2==null)return true;
    	if(root1.val!=root2.val)return false;
        return prepare(root1.left,root2.left)&&prepare(root1.right,root2.right);
    }
    public static void main(String[] args) {
    	TreeNode tree1=new TreeNode(2);
    	TreeNode tree2=new TreeNode(2);
    	TreeNode tree3=new TreeNode(3);
    	TreeNode tree4=new TreeNode(4);
    	TreeNode tree5=new TreeNode(5);
    	TreeNode tree6=new TreeNode(6);
    	TreeNode tree7=new TreeNode(7);
    	TreeNode tree8=new TreeNode(8);
    	TreeNode tree9=new TreeNode(9);
    	TreeNode tree10=new TreeNode(5);
    	TreeNode tree11=new TreeNode(2);
    	TreeNode tree12=new TreeNode(4);
    	TreeNode tree13=new TreeNode(5);
    	TreeNode tree14=new TreeNode(8);
    	tree1.left=tree2;
    	tree1.right=tree3;
    	tree2.left=tree4;
    	tree2.right=tree5;
    	tree3.right=tree6;
    	tree4.left=tree7;
    	tree5.left=tree8;
    	tree5.right=tree9;
    	tree6.right=tree10;
    	tree11.left=tree12;
    	tree11.right=tree13;
    	tree13.right=tree14;
    	
    	
    	System.out.println(HasSubtree(tree1,tree11));
	}
}
