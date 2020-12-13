/*
  		Question : Minimum Absolute Differnce In BST
  		Question Code : 530
  		Question Category : Easy
*/
class Triple{
	
	int max,min,ans;
	
	public Triple() {
	}
	
	public Triple(int x,int y,int z) {
		this.max=x;
		this.min=y;
		this.ans=z;
	}
	
}
public class MinimumAbsoluteDifferenceInBST {
    
	public int getMinimumDifference(TreeNode root) {
      return getMinimumDifferenceHelper(root).ans;    
    }
	
	public Triple getMinimumDifferenceHelper(TreeNode root) {
         	
		if(root.left==null&&root.right==null) {
		    return new Triple(root.val,root.val,1000);	
		}
		
		
		int max=root.val,min=root.val;
		
		Triple left=new Triple();
		
		if(root.left!=null) {
			left=getMinimumDifferenceHelper(root.left);
		    max=Math.max(left.max, left.min);
		    min=Math.min(left.max, left.min);
		}
		
		
		Triple right=new Triple();
		
		if(root.right!=null) {
			right=getMinimumDifferenceHelper(root.right);	
		    max=Math.max(right.max, right.min);
		    min=Math.min(right.max, right.min);
		}
		
		int ans=Math.min(Math.abs(root.val-left.max), Math.abs(root.val-right.min));
    	ans=Math.min(ans, Math.min(left.ans, right.ans));
    	max=Math.max(max, root.val);
    	min=Math.min(min, root.val);
    	    
    	return new Triple(max,min,ans);    
    }
}
