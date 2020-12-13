/*
		Leetcode  : Binary Tree Inorder Traversal
		Question Code : 94
		Category  : Medium
			
*/
import java.util.*;
public class BinaryTreeInorderTraversal {
	 
	public List<Integer> inorderTraversal(TreeNode root) {
		
		List<Integer> list=new ArrayList<Integer>();
		solveHelper(root,list);
		return list;
	}
	
	public static void solveHelper(TreeNode root,List<Integer> list) {
		
		if(root!=null) {
			solveHelper(root.left, list);
			list.add(root.val);
			solveHelper(root.right, list);
		}
	}
	
}
