/*
 		Leetcode : Delete Leaves with given values
 		Question Code:1325
 		Category : Medium
*/
public class DeleteLeavesWithGivenValue {

	 public TreeNode removeLeafNodes(TreeNode root, int target) {
		 if(root==null) {
			 return null;
		 }
		 
		 if(root.left==null&&root.right==null) {
			 if(root.val==target) {
				 return null;
			 }
			 return root;
		 }
		 
		 root.left=removeLeafNodes(root.left, target);
		 root.right=removeLeafNodes(root.right, target);
		 
		 if(root.left==null&&root.right==null&&root.val==target) {
			 return null;
		 }
		 
		 return root;
	 }
	
}
