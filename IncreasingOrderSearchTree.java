/*
		Question:Increasing Order Search Tree
		Question Code:897
		Question Category:Easy
*/
public class IncreasingOrderSearchTree {
	
	public TreeNode increasingBST(TreeNode root) {
 
//		Leaf Node
		if(root.left==null&&root.right==null) {
        	return root;
        }
		
//		Node with left subtree absent
		if(root.left==null) {
			TreeNode ans=increasingBST(root.right);
			root.right=ans;
			return root;
		}
		
		TreeNode ans=root;
		if(root.left!=null) {
			 TreeNode left=increasingBST(root.left);	  
		     ans=left;
             
		     while(left.right!=null){
                 left=left.right;
             }
		     
		     left.right=root;
		}
		
		root.left=null;
		
		
		TreeNode right=null;
		if(root.right!=null) {
			right=increasingBST(root.right);
		}
		root.right=right;
		
		return ans;
    }

}
