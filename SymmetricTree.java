/*	
		Leetcode : Symmetric Tree
		Question Code :101
		Category: Easy
*/
public class SymmetricTree {
    
	public boolean isSymmetric(TreeNode root) {
        if(root==null) {
        	return true;
        }
        return areSymmetric(root.left,root.right);
    }
    
    public boolean areSymmetric(TreeNode root1,TreeNode root2) {
    	if(root1==null&&root2==null) {
    		return true;
    	}
    	
    	if(root1==null) {
    		return false;
    	}
    	
    	if(root2==null) {
    		return false;
    	}
    	
    	if(root1.val!=root2.val) {
    		return false;
    	}
    	
    	boolean ans1=areSymmetric(root1.left, root2.right);
    	boolean ans2=areSymmetric(root1.right, root2.left);
    	
    	return (ans1&&ans2);
    }
}
