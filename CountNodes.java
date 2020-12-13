/*
		Leetcode: Count Nodes
		Question Code : 222
		Category: Medium
*/
public class CountNodes {
	 public int countNodes(TreeNode root) {
	        
	        if(root==null){
	            return 0;
	        }
	        
	        int leftAns=countNodes(root.left);
	        int rightAns=countNodes(root.right);
	        return leftAns+rightAns+1;
	    }
}
