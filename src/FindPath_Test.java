

import java.util.ArrayList;

public class FindPath_Test {

    /*
    输入一颗二叉树和一个整数，
    打印出二叉树中结点值的和为输入整数的所有路径。
    路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    */

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> resultList=new ArrayList<>();
        if(root==null){
            return resultList;
        }
        ArrayList<Integer> list=new ArrayList<>();
        resultList=FindPath2(root,target,list);
        return resultList;
    }

    public static ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target, ArrayList<Integer> list){
        ArrayList<ArrayList<Integer>> resultList=new ArrayList<>();
        ArrayList<ArrayList<Integer>> currentList;
        if(root==null) return resultList;
        int targetLeft=target-root.val;
        list.add(root.val);
        if(root.left==null&&root.right==null){
            if(targetLeft==0)resultList.add(list);
            return resultList;
        }
//        ArrayList<Integer> listleft=new ArrayList<>();
//        ArrayList<Integer> listright=new ArrayList<>();
//        listleft.addAll(list);
//        listright.addAll(list);
        ArrayList<Integer> listleft=(ArrayList<Integer>)list.clone();
        ArrayList<Integer> listright=(ArrayList<Integer>)list.clone();
        if(root.left!=null) {
            currentList=FindPath2(root.left, targetLeft, listleft);
            if(currentList.size()!=0) {
                resultList.addAll(currentList);
            }
        }
        if(root.right!=null) {
            currentList=FindPath2(root.right, targetLeft, listright);
            if(currentList.size()!=0) {
                resultList.addAll(currentList);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree3 = new TreeNode(3);
        TreeNode tree4 = new TreeNode(4);
        TreeNode tree5 = new TreeNode(5);
        TreeNode tree6 = new TreeNode(6);
        TreeNode tree7 = new TreeNode(7);
        TreeNode tree8 = new TreeNode(8);
        TreeNode tree9 = new TreeNode(9);
        TreeNode tree10 = new TreeNode(10);
        tree1.left = tree2;
        tree1.right = tree3;
        tree2.left = tree4;
        tree2.right = tree5;
        tree3.right = tree6;
        tree4.left = tree7;
        tree5.left = tree8;
        ArrayList<ArrayList<Integer>> listTest = FindPath(tree1, 16);
        System.out.println(0);
    }
}
