
public class UnivaluedBinaryTree {
	
	public boolean isUnivalTree(TreeNode root) {
		return isUnivalTree(root,root.val);
    }
	
	public boolean isUnivalTree(TreeNode root,int val) {
		if(root==null) {
			return true;
		}
		
		if(root.val!=val) {
			return false;
		}
		
		boolean leftAns=isUnivalTree(root.left,val);
		boolean rightAns=isUnivalTree(root.right,val);
		
		if((leftAns&&rightAns)==false) {
			return false;
		}
		return true;
	}
}
