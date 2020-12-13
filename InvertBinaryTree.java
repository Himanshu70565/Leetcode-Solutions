
public class InvertBinaryTree {
	
	public static TreeNode solve(TreeNode root) {
		if(root==null) {
			return null;
		}
		
		TreeNode left=solve(root.left);
		TreeNode right=solve(root.right);
		
		root.left=right;
		root.right=left;
		
		return root;
	}
	
}
