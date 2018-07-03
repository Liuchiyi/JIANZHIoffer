

import java.util.LinkedList;
import java.util.Stack;
/*先序遍历
中序遍历
后序遍历*/

public class TreeTraversal {

	    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
	        int rootnum = 0;
	    	if(pre.length==0||in.length==0||pre.length!=in.length ){
	    		return null;
	    	}
	    	TreeNode root=new TreeNode(pre[0]);
	    	for(int i=0;i<in.length;i++){
	    		if(pre[0]==in[i]){
	    			rootnum=i;
	    			break;
	    		}
	        }
	    	int [] preLeft=new int[rootnum];
	    	int [] inLeft=new int[rootnum];
	    	int [] preRight=new int[pre.length-rootnum-1];
	    	int [] inRight=new int[in.length-rootnum-1];
	    	for(int j=0;j<pre.length-1;j++){
	    		if(j<rootnum){
	    			preLeft[j]=pre[j+1];
	    			inLeft[j]=in[j];	    			
	    		}else if(j>=rootnum){
	    			preRight[j-rootnum]=pre[j+1];
	    			inRight[j-rootnum]=in[j+1];
	    		}
	    	}
	    	root.left=reConstructBinaryTree(preLeft,inLeft);
	    	root.right=reConstructBinaryTree(preRight,inRight);
	    	return root;
	}
	    public static void preOrder(TreeNode treeNode){//先序遍历递归
	    	TreeNode pNode=treeNode;
	    	if(pNode!=null){
	    		System.out.print(pNode.val+" ");
	    		preOrder(pNode.left);
	    		preOrder(pNode.right);
	  	    	}
	    }
	    
	    public static void postOrder1(TreeNode treeNode){//后序遍历递归方法
	    	TreeNode pNode=treeNode;
	    	if(pNode!=null){
	    		postOrder1(pNode.left);
	    		postOrder1(pNode.right);
	    		System.out.print(pNode.val+" ");
	    	}
	    }
	    public static void postOrder2(TreeNode treeNode){//非递归后序遍历方法1
	    	if(treeNode==null){
	    		return;
	    	}
	    	Stack stack=new Stack();
	    	TreeNode pNode=treeNode;
	    	while(pNode!=null||!stack.isEmpty()){
	    		while(pNode!=null){
	    			stack.push(pNode);
	    			pNode.val=-pNode.val;
	    			pNode=pNode.left;	    		
	    		}
	    		if(!stack.isEmpty()){
	    			pNode=(TreeNode) stack.pop();
	    			if(pNode.val<0){
	    				pNode.val=-pNode.val;
	    				stack.push(pNode);
	    				pNode=pNode.right;
	    			}else{
	    				System.out.print(pNode.val+" ");
	    				pNode=null;
	    			}	    			
	    		}
	    	}
	    }
	    	    
	    
	    public static void postOrder3(TreeNode treeNode){//非递归后序遍历方法2
	    	if(treeNode==null){
	    		return;
	    	}
	    	TreeNode pNode=treeNode;
	    	TreeNode oNode=null;
	    	Stack stack=new Stack();
	    	stack.push(pNode);
	    	while(!stack.isEmpty()){
	    		pNode=(TreeNode) stack.pop();
	    		if((pNode.left==null&&pNode.right==null)||oNode==pNode.left||oNode==pNode.right){
	    			System.out.print(pNode.val+" ");
	    			oNode=pNode;
	    		}else{
	    			stack.push(pNode);
	    			if(pNode.right!=null){
	    				stack.push(pNode.right);
	    			}
	    			if(pNode.left!=null){
	    			stack.push(pNode.left);
	    			}
	    		}
	    		
	    	}
	    }
	    
	    public static void  leverTravers(TreeNode treeNode){//层次遍历
	    	if(treeNode==null){
	    		return;
	    	}
	    	LinkedList<TreeNode> list=new LinkedList<TreeNode>();
	    	TreeNode pNode=treeNode;
	    	list.add(pNode);
	    	while(!list.isEmpty()){
	    		pNode=list.remove();
	    		System.out.print(pNode.val+" ");
	    		if(pNode.left!=null){
	    			list.add(pNode.left);
	    		}
	    		if(pNode.right!=null){
	    			list.add(pNode.right);
	    		}
	    	}
	    }
	    
	    
	    public static void main(String[] args) {
	    	
	    	int [] in=new int[8];
	    	in[0]=4;
	    	in[1]=2;
	    	in[2]=7;
	    	in[3]=5;
	    	in[4]=8;
	    	in[5]=1;
	    	in[6]=3;
	    	in[7]=6;
	    	int [] pre=new int[8];
	    	pre[0]=1;
	    	pre[1]=2;
	    	pre[2]=4;
	    	pre[3]=5;
	    	pre[4]=7;
	    	pre[5]=8;
	    	pre[6]=3;
	    	pre[7]=6;
	    	TreeNode result=reConstructBinaryTree(pre,in);    	
	    	postOrder1(result);
	    	System.out.println("后序遍历");
	    	preOrder(result);
	    	System.out.println("先序遍历");
	    	postOrder2(result);
	    	System.out.println("后序遍历");
	    	postOrder3(result);
	    	System.out.println("后序遍历");
	    	leverTravers(result);
	    	System.out.println("层次遍历");
	    	
		}
}
