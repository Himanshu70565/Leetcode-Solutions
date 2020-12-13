/*
 		Question : Two Sum Four: Input is a BST
 		Question Code:653
 		Question Category:Easy
*/
import java.util.*;
public class TwoSumFour {
	 
	 public boolean findTarget(TreeNode root, int k) {
	     
		 ArrayList<Integer> list=new ArrayList<Integer>();
		 inorderTraversal(list,root);
		 
		 boolean isExist=false;
		 
		 int start=0;
		 int end=list.size()-1;
		 
		 while(start<end) {
		     if(list.get(start)+list.get(end)==k) {
		    	 isExist=true;
		    	 break;
		     }else if(list.get(start)+list.get(end)<k) {
		    	 start++;
		     }else {
		    	 end--;
		     }
		 }
		 
		 return isExist;
	 }
	 
	 public static void inorderTraversal(ArrayList<Integer> list,TreeNode root){
		
		 if(root==null) {
			 return;
		 }
		 
		 inorderTraversal(list, root.left);
		 list.add(root.val);
		 inorderTraversal(list, root.right);
		 		 
	 }
}
