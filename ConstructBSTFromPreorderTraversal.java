/*
		Question:Construct BST From Preorder Traversal
		Question Code:1008
		Question Category:Medium
*/
public class ConstructBSTFromPreorderTraversal {

	public TreeNode bstFromPreorder(int[] preorder) {
       
		TreeNode root=null;
		int n=preorder.length;
		
		for(int i=0;i<n;i++) {
			root=insertNode(root, preorder[i]);
		}
		
		return root;
    }
	
	public TreeNode insertNode(TreeNode root,int val) {
		
		if(root==null) {
		   TreeNode newNode=new TreeNode(val);
		   return newNode;
		}
		
		if(root.val>val) {
			root.left=insertNode(root.left, val);
		}
		
		if(root.val<val) {
			root.right=insertNode(root.right, val);
		}
		
		return root;
	}
}
