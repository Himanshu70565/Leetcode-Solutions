/*
 		Question:Maximum Level Sum of Binary Tree
 		Question Code:1161
 		Question Category:Medium
*/
import java.util.*;
public class MaximLevelSumOfBinaryTree {
	 
	 public int maxLevelSum(TreeNode root) {
	    
		 int maxSum=Integer.MIN_VALUE,maxLevel=1,level=1;
		 Queue<TreeNode> queue=new LinkedList<TreeNode>();
		 queue.add(root);
		 
		 while(!queue.isEmpty()) {
			 
			 int size=queue.size();
			 int sum=0;
			 
			 for(int i=0;i<size;i++) {
				 TreeNode frontNode=queue.poll();
				 
				 if(frontNode.left!=null) {
					 queue.add(frontNode.left);
				 }
				 
				 if(frontNode.right!=null) {
					 queue.add(frontNode.right);
				 }
				 
				 sum+=frontNode.val;
				 
			 }
			 
			 if(maxSum<sum) {
				 maxSum=sum;
				 maxLevel=level;
			 }
			 
			 level++;
		 }
		 
		 return maxLevel;
	 }
}
