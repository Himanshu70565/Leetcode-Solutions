/*
 		Leetcode :Check Completeness of a Binary Tree
 		Question Code : 958
 		Category : Medium
*/
import java.util.*;
public class CheckCompletenessOfABinaryTree {
	
	public boolean isCompleteTree(TreeNode root) {
	
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		
		boolean end=false;
		
		while(!queue.isEmpty()) {
			
			TreeNode frontNode=queue.poll();
			
			if(frontNode==null) {
				end=true;
			}else {
				if(end==true) {
					return false;
				}
				queue.add(frontNode.left);
				queue.add(frontNode.right);
			}
			
		}
			return true;
    }
	
}
