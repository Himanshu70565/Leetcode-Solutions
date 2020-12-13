/*
 		Question : Trim a Binary Search Tree
 		Question Code:669
 		Question Category: Easy
*/
public class TrimABinarySearchTree {
		
	public TreeNode trimBST(TreeNode root, int low, int high) {
        
	    if(root==null) {
	    	return null;
	    }
	
		TreeNode ans=root;
		TreeNode left=trimBST(root.left, low, high);
		TreeNode right=trimBST(root.right, low, high);
		
		if(root.val>=low&&root.val<=high) {
			ans.left=left;
			ans.right=right;
		}else {
		
			if(left==null) {
				return right;
			}
			if(right==null) {
				return left;
			}
			
			ans=left;
			while(left.right!=null) {
				left=left.right;
			}
			left.right=right;
			
		}
		return ans;
    }
	
}
