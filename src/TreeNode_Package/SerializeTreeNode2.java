package TreeNode_Package;

import java.util.LinkedList;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 先序递归遍历
 */


public class SerializeTreeNode2 {
    String Serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if(root == null) {
            str.append("#!");
            return str.toString();
        }
        str.append(root.val + "!");
        str.append(Serialize(root.left));
        str.append(Serialize(root.right));
        return str.toString();
    }


//非递归
/*    TreeNode Deserialize(String str) {
        String [] s = str.split("!");
        if(s[0].equals("#")) return null;
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        list.add(root);
        int curNum = 1;
        while(curNum < s.length){
            if(!s[curNum].equals("#")){
                TreeNode pNode = list.peekLast();
                pNode.left = new TreeNode(Integer.parseInt(s[curNum]));
                list.add(pNode.left);
                curNum++;
            }else {
                curNum++;
                TreeNode pNode = list.pollLast();
                if(curNum < s.length && !s[curNum].equals("#")){
                    pNode.right = new TreeNode(Integer.parseInt(s[curNum]));
                    list.add(pNode.right);
                    curNum++;
                }else {
                    curNum++;
                    if(curNum < s.length && !s[curNum].equals("#")) {
                        pNode = list.pollLast();
                        pNode.right = new TreeNode(Integer.parseInt(s[curNum]));
                        list.add(pNode.right);
                        curNum++;
                    }
                }
            }
        }
        return root;
    }*/

    public int index = -1;
    TreeNode Deserialize(String str) {
        index++;
        String [] s = str.split("!");
        TreeNode node = null;
        if(!s[index].equals("#")){
            node = new TreeNode(Integer.parseInt(s[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
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
        SerializeTreeNode2 test = new SerializeTreeNode2();
        System.out.println(test.Serialize(node1));
        String s = test.Serialize(node1);
        TreeNode a =test.Deserialize(s);
    }
}
