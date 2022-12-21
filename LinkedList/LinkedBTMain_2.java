package ass;

import ass.BinaryTree;
import ass.TreeNode;

class TreeNode {
	char data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(char data1){//constructor
		data = data1;
		left=null;
		right=null;
	}
}

class BinaryTree {
	
	private TreeNode root;
	
	public static int count;
	public static int leafcount;
	
	public TreeNode makenode(TreeNode leftv, char data, TreeNode rightv){
		root = new TreeNode(data);
		root.left=leftv;
		root.right=rightv;
		return root;
	}
	public void preorder(TreeNode root){
		if(root!=null){
			System.out.print(root.data+", ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void postorder(TreeNode root){
		if(root!=null){
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data+", ");
		}
	}
	
	public void inorder(TreeNode root){
		if(root!=null){
			inorder(root.left);
			System.out.print(root.data+", ");
			inorder(root.right);
		}
	}
	public int nodecount(TreeNode root){
		if(root!=null){
			this.count++;
			nodecount(root.left);
			nodecount(root.right);
			}
			return this.count;
			}
	
	public int countDepth(TreeNode root) {
		int count = -1;
		if(root != null){
		count = 1 + Math.max(countDepth(root.left),countDepth(root.right));
		}
		return count;
		}
	
	public int countLeaf(TreeNode root) {
		if(root!=null){
			if((root.left==null) && (root.right==null)){ 
				this.leafcount++;
				}
			countLeaf(root.left);
			countLeaf(root.right);
			}
			return this.leafcount;
	}
}

public class LinkedBTMain_2 {
	public void BT(){};
	public static void main(String[] args){
		BinaryTree tree1 = new BinaryTree();
		TreeNode node1 = tree1.makenode(null,'E',null);
		TreeNode node2 = tree1.makenode(node1,'G',null);
		TreeNode node3 = tree1.makenode(null,'A',null);
		TreeNode node4 = tree1.makenode(null,'D',node2);
		TreeNode node5 = tree1.makenode(node3,'B',node4);
		TreeNode node6 = tree1.makenode(null,'Q',null);
		TreeNode node7 = tree1.makenode(node6,'R',null);
		TreeNode node8 = tree1.makenode(null,'M',node7);
		TreeNode node9 = tree1.makenode(node5,'J',node8);
		TreeNode node10 = tree1.makenode(null,'U',null);
		TreeNode node11 = tree1.makenode(node9,'S',node10);//root
		System.out.println("Preorder");
		tree1.preorder(node11);
		System.out.println("\n");
		System.out.println("Postorder");
		tree1.postorder(node11);
		System.out.println("\n");
		System.out.println("Inorder");
		tree1.inorder(node11);
		System.out.println("\n");
		
		System.out.println("node count");
		System.out.println(tree1.nodecount(node11));
		System.out.println();
		
		System.out.println("Depth");
		System.out.println(tree1.countDepth(node11));
		System.out.println();
		
		System.out.println("Leafcount");
		System.out.println(tree1.countLeaf(node11));
		System.out.println();
		
	}
}
