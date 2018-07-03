package TreeNode_Package;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 层次遍历（记录每层的个数）
 */
public class Print_Test {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res =new ArrayList<>();
        if(pRoot == null) return res;
        ArrayList<Integer> cList = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(pRoot);
        while (!list.isEmpty()){
            int size = list.size();
            while (size-- > 0){
                TreeNode pNode = list.pop();
                cList.add(pNode.val);
                if(pNode.left != null){
                    list.add(pNode.left);
                }
                if(pNode.right != null){
                    list.add(pNode.right);
                }
            }
            res.add(new ArrayList<>(cList));
            cList.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
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
        Print_Test test = new Print_Test();
        ArrayList<ArrayList<Integer>> res = test.Print(node1);
        System.out.println(res.get(1).size());
    }
}
