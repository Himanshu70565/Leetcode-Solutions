/*
 		Leetcode : Balanced Binary Tree
 		Question Code : 110
 		Category: Easy 
*/
public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		if(root==null) {
			return true;
		}
		
		int leftHeight=height(root.left);
		int rightHeight=height(root.right);
		
		if(Math.abs(leftHeight-rightHeight)>1) {
			return false;
		}
		
		boolean leftAns=isBalanced(root.left);
		boolean rightAns=isBalanced(root.right);
		
		return (leftAns&&rightAns);
    }
	
	public static int height(TreeNode root) {
		if(root==null) {
			return 0;
		}
		
		int h1=height(root.left);
		int h2=height(root.right);
		
		return (Math.max(h1, h2)+1);
	}
	
	public Pair<Boolean,Integer> isBalancedImproved(TreeNode root) {
		if(root==null) {
				return new Pair(true,0);
		}
			
		Pair<Boolean,Integer> leftAns=isBalancedImproved(root.left);
		Pair<Boolean,Integer> rightAns=isBalancedImproved(root.right);
		
		if(((leftAns.first&&rightAns.first)==false)||(Math.abs(leftAns.second-rightAns.second)>1)) {
			return new Pair(false, Math.max(leftAns.second,rightAns.second)+1);
		}
		
		return new Pair(true,Math.max(leftAns.second,rightAns.second)+1);
	}
	
}
