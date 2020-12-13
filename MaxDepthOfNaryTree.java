/*
 		Leetcode : Maximum Depth of a N-ary Tree
 		Question Code : 559
 		Category : Easy
*/
public class MaxDepthOfNaryTree {
	 
	public int maxDepth(Node root) {
		if(root==null) {
			return 0;
		}
		
		int ans=0;
		for(int i=0;i<root.children.size();i++) {
			ans=Math.max(ans,maxDepth(root.children.get(i)));
		}
		
		return ans+1;  
	}
	
}
