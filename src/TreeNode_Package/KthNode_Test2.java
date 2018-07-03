package TreeNode_Package;



public class KthNode_Test2 {
    int NUM;
    TreeNode resNode = null;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(k < 1) return null;
        if(pRoot == null) return null;
        NUM = 0;
        InTravelsalHelper(pRoot,k);
        return resNode;
  }

    private void InTravelsalHelper(TreeNode pRoot,int k) {
        if(pRoot != null){
            InTravelsalHelper(pRoot.left,k);
            NUM++;
            if(NUM == k){
                resNode = pRoot;
                return;
            }
            InTravelsalHelper(pRoot.right,k);
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
        KthNode_Test2 test = new KthNode_Test2();
        System.out.println(test.KthNode(node1,5).val);
    }
}
