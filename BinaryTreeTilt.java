/*
		Leetcode : Binary Tree Tilt
		Question Code :563
		Category : Easy
*/		
public class BinaryTreeTilt {
	
	public int findTilt(TreeNode root) {
		return solveHelper(root).first;
    }
	
	public Pair<Integer,Integer> solveHelper(TreeNode root){
		if(root==null) {
			return new Pair(0,0);
		}
	
		Pair<Integer,Integer> leftAns=solveHelper(root.left);
		Pair<Integer,Integer> rightAns=solveHelper(root.right);
		
		return new Pair(leftAns.first+rightAns.first+Math.abs(leftAns.second-rightAns.second),leftAns.second+rightAns.second+root.val);
	}
}
