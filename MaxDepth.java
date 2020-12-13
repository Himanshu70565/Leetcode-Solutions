/*
 		Leetcode : Maximum Depth 
 		Question Code :104
 		Category : Easy
*/
public class MaxDepth {
	 
	public int maxDepth(TreeNode root) {
	        if(root==null){
	            return 0;
	        }
	        int h1=maxDepth(root.left);
	        int h2=maxDepth(root.right);
	        return Math.max(h1,h2)+1;
	}
}
