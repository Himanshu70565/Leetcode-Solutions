/*
 		Leetcode : Add One Row To A Tree
 		Question Code : 623
 		Category :Medium
*/
public class AddOneRowToATree {
	
	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if(d==1){
            TreeNode newNode=new TreeNode(v);
            newNode.left=root;
            return newNode;
        }
		return solve(root,v,d,0);
    }
	
	public TreeNode solve(TreeNode root,int val,int d,int current) {
		if(root==null) {
			return null;
		}
		
		if(current+1==d) {
			TreeNode left=root.left;
			TreeNode right=root.right;
			
			TreeNode newNode1=new TreeNode(val);
			TreeNode newNode2=new TreeNode(val);
			
			newNode1.left=left;
			newNode2.right=right;
			root.left=newNode1;
			root.right=newNode2;
			
			return root;
		}
		
		root.left=solve(root.left, val, d, current+1);
		root.right=solve(root.right, val, d, current+1);
		
		return root;
	}
}
