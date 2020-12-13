/*
		Leetcode :Leaf Similiar Tree
		Question Code :872
		Category :Easy
*/

import java.util.*;
public class LeafSimiliarTree {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		ArrayList<Integer> arr1=solve(root1);
		ArrayList<Integer> arr2=solve(root2);
		
		if(arr1.size()!=arr2.size()) {
			return false;
		}
		
		for(int i=0;i<arr1.size();i++) {
			if(arr1.get(i)!=arr2.get(i)) {
				return false;
			}
		}
		return true;
    }
	
	public static ArrayList<Integer> solve(TreeNode root) {
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.add(root);
		
		while(!stack.isEmpty()) {
			
			TreeNode frontNode=stack.pop();
			
			if(frontNode.left==null&&frontNode.right==null) {
				list.add(frontNode.val);
			}
			
			if(frontNode.right!=null) {
				stack.add(frontNode.right);
			}
			
			if(frontNode.left!=null) {
				stack.add(frontNode.left);
			}
		}
	
		return list;
	}
	
}
