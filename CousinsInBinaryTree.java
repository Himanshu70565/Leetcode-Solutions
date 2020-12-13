/*
		Leetcode : Cousins in Binary Tree
		Question Code :993
		Category : Easy
*/		
import java.util.*;
public class CousinsInBinaryTree {
	  
	public boolean isCousins(TreeNode root, int x, int y) {
	        
		  Pair<Integer,Integer> parent1=findParent(root, x);
		  Pair<Integer,Integer> parent2=findParent(root, y);
		  
		  if(parent1.first!=parent2.first&&parent1.second==parent2.second) {
			  return true;
		  }
		  
		  return false;
		  
	  }
	  
	public Pair<Integer,Integer> findParent(TreeNode root,int child){
		 
		  Queue<TreeNode> queue=new LinkedList<TreeNode>();
		  queue.add(root);
		  int level=0;
		  
		  while(!queue.isEmpty()) {  
			  int size=queue.size();
			  for(int i=0;i<size;i++) {
				  TreeNode frontNode=queue.poll();
				  
				  if(frontNode.left!=null) {
					  if(frontNode.left.val==child) {
						  return new Pair(frontNode,level);
					  }
					  queue.add(frontNode.left);
				  }
				  
				  if(frontNode.right!=null) {
					  if(frontNode.right.val==child) {
						  return new Pair(frontNode,level);
					  }
					  queue.add(frontNode.right);
				  }
			  }
			  level++;
		  }
		
		 return new Pair<Integer,Integer>(-1,-1);
	  }
	  
}
