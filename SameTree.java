/*
 		Leetcode : Same Tree
 		Question Code :100
 		Category : Easy
*/
public class SameTree {
	 
	public boolean isSameTree(TreeNode p, TreeNode q) {
		
		if(p==null&&q==null) {
			return true;
		}
		
		if(p==null||q==null) {
			return false;
		}
		
		boolean left=isSameTree(p.left,q.left);
		boolean right=isSameTree(p.right,q.right);
		
		if(left&&right==false) {
			return false;
		}
		
		if(p.val!=q.val){
            return false;
        }
		
		return true;
	}
}
