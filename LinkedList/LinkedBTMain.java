package ass;


 class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data1){//constructor
		data = data1;
		left=null;
		right=null;
	}
}

class BinaryTree {
	
	private TreeNode root;
	
	public static int count;
	public static int leafcount;
	
	public TreeNode makenode(TreeNode leftv, int data, TreeNode rightv){
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

public class LinkedBTMain {
	public void BT(){};
	public static void main(String[] args){
		BinaryTree tree1 = new BinaryTree();
		TreeNode node1 = tree1.makenode(null,1,null);
		TreeNode node2 = tree1.makenode(null,7,null);
		TreeNode node3 = tree1.makenode(node1,3,node2);
		TreeNode node4 = tree1.makenode(null,14,null);
		TreeNode node5 = tree1.makenode(node3,9,node4);
		TreeNode node6 = tree1.makenode(null,44,null);
		TreeNode node7 = tree1.makenode(null,36,node6);
		TreeNode node8 = tree1.makenode(null,97,null);
		TreeNode node9 = tree1.makenode(null,94,node8);
		TreeNode node10 = tree1.makenode(node7,67,node9);
		TreeNode node11 = tree1.makenode(node5,22,node10);//root
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
