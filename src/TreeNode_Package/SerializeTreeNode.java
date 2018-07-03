package TreeNode_Package;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 层次遍历
 */

import java.util.Iterator;
import java.util.LinkedList;

public class SerializeTreeNode {
    String Serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        LinkedList<TreeNode> list = new LinkedList<>();
        if(root == null){
            s.append("#!");
        }
        list.add(root);
        boolean flag = true;
        while (flag){
            flag = false;
            int size = list.size();
            while (size -- > 0){
                TreeNode pNode = list.pop();
                if(pNode != null){
                    s.append(pNode.val + "!");
                    if(pNode.left != null){
                        list.add(pNode.left);
                    }else {
                        list.add(null);
                    }
                    if(pNode.right != null){
                        list.add(pNode.right);
                    }else {
                        list.add(null);
                    }
                }else {
                    s.append("#!");
                    list.add(null);
                    list.add(null);
                }
            }
            Iterator<TreeNode> iterator = list.iterator();
            while (iterator.hasNext()){
                if(iterator.next() != null){
                    flag=true;
                    break;
                }
            }
        }
        return s.toString();
    }


    TreeNode Deserialize(String str) {
//        StringBuilder sb = new StringBuilder(str);
//        int size = 0;
//        for (int i = 0; i < sb.length(); i++) {
//            if(sb.charAt(i) == '!'){
//                size++;
//            }
//        }
//        String[] node = new String[size];
//        int num = 0;
//        int start = 0;
//        for (int i = 0; i < sb.length(); i++) {
//            if(sb.charAt(i) == '!'){
//                node[num++] = sb.substring( start,i);
//                start = i + 1;
//            }
//        }
        String[] node = str.split("!");

        LinkedList<TreeNode> list = new LinkedList();
        if(node[0].equals("#") ) return null;
        TreeNode root =new TreeNode(Integer.parseInt(node[0]));
        list.add(root);
        int curNum = 1;
        while(curNum < node.length){
            TreeNode pNode = list.pop();
            if(!node[curNum].equals("#") ){
                pNode.left = new TreeNode(Integer.parseInt(node[curNum]));
                list.add(pNode.left);
                curNum++;
            }else {
                list.add(null);
                curNum++;
            }
            if(!node[curNum].equals("#")){
                pNode.right = new TreeNode(Integer.parseInt(node[curNum]));
                list.add(pNode.right);
                curNum++;
            }else {
                list.add(null);
                curNum++;
            }
        }
        return root;
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
//        node2.left=node4;
//        node2.right=node5;
//        node3.left=node6;
        node3.right=node7;
        SerializeTreeNode test = new SerializeTreeNode();
        System.out.println(test.Serialize(node1));
        String s = test.Serialize(node1);
        test.Deserialize(s);
    }
}
