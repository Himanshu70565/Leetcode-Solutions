import java.util.PriorityQueue;

/*		
		Leetcode : Second Minimum Node in a Binary Tree
		Question Code : 671
		Category : Easy
*/		
public class SecondMinimumNodeInBinaryTree {

	public int findSecondMinimumValue(TreeNode root) {
		return solve(root).second;
    }
	
	public Pair<Integer,Integer> solve(TreeNode root){
		if(root==null) {
			return new Pair(Integer.MAX_VALUE,Integer.MAX_VALUE);
		}
		
		if(root.left==null&&root.right==null) {
			return new Pair(root.val,root.val);
		}
		
		Pair<Integer,Integer> leftAns=solve(root.left);
		Pair<Integer,Integer> rightAns=solve(root.right);
		
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
		queue.add(leftAns.first);
		queue.add(leftAns.second);
		queue.add(rightAns.first);
		queue.add(rightAns.second);
		
		int min=queue.poll();
		
		int s_min;
		while(true) {
			s_min=queue.poll();
			if(s_min!=min) {
				break;
			}
		}
		
		return new Pair(min,s_min);
		
	}
}
