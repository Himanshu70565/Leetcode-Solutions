
public class BinaryTreePruning {
	
	public TreeNode pruneTree(TreeNode root) {
		
		if(root==null) {
			return null;
		}
		
		TreeNode left=pruneTree(root.left);
		TreeNode right=pruneTree(root.right);
		
		root.left=left;
		root.right=right;
		
		if(root.left==null&&root.right==null&&root.val==0) {
			return null;
		}
		
		return root;
	}
	
}
