/*
 		Leetcode : Deepest Leaves Sum
 		Question Code : 1302
 		Category : Medium
*/
import java.util.*;
public class DeepestLeavesSum {

	  public int deepestLeavesSum(TreeNode root) {
	      
		  Queue<TreeNode> queue=new LinkedList<TreeNode>();
		  queue.add(root);
		  
		  int sum=root.val;
		  
		  while(!queue.isEmpty()) {
			  
			  int size=queue.size();
			  int ans=0;
			  for(int i=0;i<size;i++) {
				  
				  TreeNode frontNode=queue.poll();
				  ans+=frontNode.val;
				  
				  if(frontNode.left!=null) {
					  queue.add(frontNode.left);
				  }
				  
				  if(frontNode.right!=null) {
					  queue.add(frontNode.right);
				  }
				  
			  }
			sum=ans;
		  }
		  return sum;
	  }
	
}
