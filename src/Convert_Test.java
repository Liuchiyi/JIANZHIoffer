
/*
二叉搜索树与双向链表

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。
*/

public class Convert_Test {

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;
        TreeNode resultNode=pRootOfTree;
        TreeNode tempLeft=pRootOfTree.left;//保存左节点
        TreeNode tempright=pRootOfTree.right;//保存右节点
        if(pRootOfTree.right!=null){
            TreeNode curright=pRootOfTree.right;//当前不为空的最小值的节点
            while(curright.left!=null)curright=curright.left;
            pRootOfTree.right=curright;
            curright.left=pRootOfTree;
            if(tempright.left==pRootOfTree){
                while(tempright.right!=null&&tempright.right.left==null){
                    tempright.right.left=tempright;
                    tempright=tempright.right;
                }
                resultNode=tempright;
            }else {
                resultNode=Convert(tempright);
            }
        }
        if(pRootOfTree.left!=null){
            TreeNode curleft=pRootOfTree.left;//当前不为空的最大值的节点
            while(curleft.right!=null)curleft=curleft.right;
            pRootOfTree.left=curleft;
            curleft.right=pRootOfTree;
            if(tempLeft.right==pRootOfTree){
                while(tempLeft.left!=null&&tempLeft.left.right==null){
                    tempLeft.left.right=tempLeft;
                    tempLeft=tempLeft.left;
                }
                resultNode=tempLeft;
            }else {
                resultNode = Convert(tempLeft);
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
