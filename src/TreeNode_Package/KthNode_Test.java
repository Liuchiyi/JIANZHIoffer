package TreeNode_Package;

import java.util.ArrayList;

public class KthNode_Test {
    TreeNode MAX;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null) return null;
        if(k < 1) return null;
        ArrayList<TreeNode> list = new ArrayList<>(k);
        MAX = null;
        preTraversalHelper(pRoot,list,k);
        return MAX;
    }

    private void preTraversalHelper(TreeNode pRoot, ArrayList<TreeNode> list,int k) {
        if (pRoot != null){
            if(list.size() < k) list.add(pRoot);
            if(list.size() == k) {
                if(MAX != null && pRoot.val < MAX.val){
                    ListAdjst(list,pRoot);
                }
                maxTreenode(list);
            }
            preTraversalHelper(pRoot.left,list,k);
            preTraversalHelper(pRoot.right,list,k);
        }
    }

    private void ListAdjst(ArrayList<TreeNode> list,TreeNode node) {
        list.remove(MAX);
        list.add(node);
        MAX = list.get(0);
        for (int i = 1; i < list.size(); i++){
            if(MAX.val < list.get(i).val){
                MAX = list.get(i);
            }
        }
    }

    private void maxTreenode(ArrayList<TreeNode> list) {
        if(MAX == null){
            MAX = list.get(0);
            for (int i = 1; i < list.size(); i++){
                if(MAX.val < list.get(i).val){
                    MAX = list.get(i);
                }
            }
        }
    }


    public static void main(String[] args) {
        TreeNode node1=new TreeNode(9);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        KthNode_Test test = new KthNode_Test();
        System.out.println(test.KthNode(node1,7).val);
    }
}
