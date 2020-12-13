/*
		Leetcode : Count Good Nodes In  a Binary Tree
		Question Code : 1448
		Category: Medium
*/		
public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        return solve(root,root.val);
    }

    public int solve(TreeNode root,int max_till_now) {
    	if(root==null) {
    		return 0;
    	}
    	
    	max_till_now=Math.max(max_till_now, root.val);
    	
    	int leftAns=solve(root.left,max_till_now);
    	int rightAns=solve(root.right, max_till_now);
    	
    	int ans=0;
    	if(root.val>=max_till_now) {
    		ans=1;
    	}
    	
    	return (ans+leftAns+rightAns);
    }
}
