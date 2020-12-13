/*
		Question:Find A Corresponding Node Of A Binary Tree In Clone Of That Tree
		Question Code:1379
		Question Category:Medium
*/
public class FindACorrespondingNodeOfABinaryTreeInCloneOfThatTree {

	 public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
	        
		 return findNode(cloned, target.val);
		 
	 }
	 
	 public TreeNode findNode(TreeNode root,int val) {
		 if(root==null) return null;
		 
		 TreeNode left=findNode(root.left, val);
		 
		 TreeNode right=findNode(root.right, val);
		 
		 if(left!=null) {
			 return left;
		 }
		 
		 if(right!=null) {
			 return right;
		 }
		 
		 return root.val==val ? root:null;
	 }
	
}
