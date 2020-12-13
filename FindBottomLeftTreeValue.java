import java.util.LinkedList;
import java.util.Queue;

/*
		Leetcode : Find Bottom Left Tree Value
		Question Code : 513
		Category : Medium 
*/
public class FindBottomLeftTreeValue {
	 
	
	 public int findBottomLeftValue(TreeNode root) {
		 
		 int ans=root.val;
		 Queue<TreeNode> queue=new LinkedList<TreeNode>();
		 queue.add(root);
		 
		 while(!queue.isEmpty()) {
			 
			 boolean first=true;
			 
			 int size=queue.size();
			 
			 for(int i=0;i<size;i++) {
				 TreeNode firstNode=queue.poll();
				 if(first==true) {
					 ans=firstNode.val;
					 first=false;
				 }
				 
				 if(firstNode.left!=null) {
					 queue.add(firstNode.left);
				 }
				 
				 if(firstNode.right!=null) {
					 queue.add(firstNode.right);
				 }
			 }
		 }
		 return ans;
	 }
}
