/*
		Leetcode :Sum of Root to Leaf Binary Numbers
		Question Code : 1022
		Category : Easy
*/
public class SumOfRootToLeafBinaryNumbers {
	
	public int sumRootToLeaf(TreeNode root) {
		 return solveHelper(root,0);
    }
	
	public static int solveHelper(TreeNode root,int num) {
		if(root==null) {
			return 0;
		}
		if(root.left==null&&root.right==null) {
			num=num<<1;
			num=num^root.val;
			return num;
		}
		
		num=num<<1;
		num=num^root.val;
		
		int leftAns=solveHelper(root.left, num);
		int rightAns=solveHelper(root.right, num);
		
		return leftAns+rightAns;
	}

}
