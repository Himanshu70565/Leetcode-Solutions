
public class SumOfLeftLeaves {
	
	 public int sumOfLeftLeaves(TreeNode root) {
		 if(root==null) {
			 return 0;
		 }
		 
		 int leftAns=sumOfLeftLeaves(root.left);
		 int rightAns=sumOfLeftLeaves(root.right);
		 
		 if(root.left!=null&&root.left.left==null&&root.left.right==null) {
			 return leftAns+rightAns+root.left.val;
		 }
		 
		 return leftAns+rightAns;
	}
	
}
