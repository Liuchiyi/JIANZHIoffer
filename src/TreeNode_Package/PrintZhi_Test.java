package TreeNode_Package;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 层次遍历，用null节点来标记层数，同时借助LinkedList的双向链表特性，用遍历器来遍历每一层
 */
public class PrintZhi_Test {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        ArrayList<Integer> cList = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(null);
        list.add(pRoot);
        boolean leftToRight = false;
        while (list.size() != 1){
            TreeNode pNode = list.pop();
            if(pNode ==null){
                leftToRight = !leftToRight;
                Iterator<TreeNode> iterator = null;
                if(leftToRight){
                    iterator = list.iterator();
                }else {
                    iterator = list.descendingIterator();
                }
                while (iterator.hasNext()){
                    cList.add(iterator.next().val);
                }
                res.add(new ArrayList<Integer>(cList));
                cList.clear();
                list.add(null);
                continue;
            }
            if(pNode.left != null){
                list.add(pNode.left);
            }
            if(pNode.right != null){
                list.add(pNode.right);
            }
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
        PrintZhi_Test test = new PrintZhi_Test();
        ArrayList<ArrayList<Integer>> res = test.Print(node1);
        System.out.println(res.get(2).size());

    }
}
