/*	
		Leetcode: Subtree of Another Tree
		Question Code : 572
		Category : Easy
*/		
import java.util.*;
public class SubtreeOfAnotherTree {
	
	 public boolean isSubtree(TreeNode s, TreeNode t) {
		 return findAddress(s,t);
	}
	 
	 public boolean findAddress(TreeNode s,TreeNode t) {
		 
		 Stack<TreeNode> stack=new Stack<TreeNode>();
		 stack.add(s);
		 
		 while(!stack.isEmpty()) {
			 
			 TreeNode frontNode=stack.pop();
			 
			 if(frontNode.val==t.val) {
				 boolean ans=isSubtreeHelper(frontNode, t);
				 if(ans==true) {
					 return true;
				 }
			 }
			 
			 if(frontNode.left!=null) {
				 stack.add(frontNode.left);
			 }
			 
			 if(frontNode.right!=null) {
				 stack.add(frontNode.right);
			 }
		 }		
		 
		 return false;
	 }
	
	 public boolean isSubtreeHelper(TreeNode root1,TreeNode root2) {
		 if(root1==null&&root2==null) {
			 return true;
		 }
		 
		 if(root1==null||root2==null) {
			 return false;
		 }
		 
		 if(root1.val!=root2.val) {
			 return false;
		 }
		 
		 boolean leftAns=isSubtreeHelper(root1.left, root2.left);
		 boolean rightAns=isSubtreeHelper(root1.right, root2.right);
		 
		 return (leftAns&&rightAns);
	 }
}
