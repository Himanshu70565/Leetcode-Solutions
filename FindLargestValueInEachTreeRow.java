import java.util.*;
/*
		Leetcode :  Find Largest Value in Each Tree Row
		Question Code : 515
		Category:Medium
*/
public class FindLargestValueInEachTreeRow {

	 public List<Integer> largestValues(TreeNode root) {
	 
		 List<Integer> list=new ArrayList<Integer>();
		 if(root==null) {
			 return list;
		 }
		 
		 Queue<TreeNode> queue=new LinkedList<TreeNode>();
		 queue.add(root);
		 
		 while(!queue.isEmpty()) {
			 int size=queue.size();
			 
			 int max=Integer.MIN_VALUE;
			 for(int i=0;i<size;i++) {
				 
				 TreeNode frontNode=queue.poll();
				 max=Math.max(frontNode.val,max);
				 
				 if(frontNode.left!=null) {
					 queue.add(frontNode.left);
				 }
				 
				 if(frontNode.right!=null) {
					 queue.add(frontNode.right);
				 }
			 }
			 list.add(max);
		 }
		 return list;
	 }
	
}
