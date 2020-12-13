/*
 		Leetcode : Path Sum
 		Question Code : 112
 		Category : Easy
*/
public class PathSum {
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null){
            return false;
        }
        return hasPathSumH(root,sum);
    }
    
    public boolean hasPathSumH(TreeNode root,int sum){
        
		if(root.left==null&&root.right==null) {
        	if(sum-root.val==0) {
				return true;
			}
			return false;
		}
		
		
        boolean leftAns=false,rightAns=false;
        
        if(root.left!=null){
            leftAns=hasPathSumH(root.left, sum-root.val);    
        }
		
        if(root.right!=null){
            rightAns=hasPathSumH(root.right, sum-root.val);
        }
		
		
		return (leftAns||rightAns);
    }

}
