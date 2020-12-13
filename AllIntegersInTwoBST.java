import java.util.*;
/*
		Question:All Integers In Two BST
		Question Code:1305
		Question Category:Medium
*/
public class AllIntegersInTwoBST {

	 public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		 
		 List<Integer> list1=new ArrayList<Integer>();
		 List<Integer> list2=new ArrayList<Integer>();
		 List<Integer> finalList=new ArrayList<Integer>();
		 
		 
		 traverse(list1, root1);
		 traverse(list2, root2);
		 
		 int i=0,j=0,n=list1.size(),m=list2.size();
		 
		 while(i<n&&j<m) {
			 
			 if(list1.get(i)<list2.get(j)) {
				 finalList.add(list1.get(i));
				 i++;
			 }else {
				 finalList.add(list2.get(j));
				 j++;
			 }
			 
		 }
		 
		 while(i<n) {
			 finalList.add(list1.get(i));
			 i++;
		 }
		 
		 while(j<m) {
			 finalList.add(list2.get(j));
			 j++;
		 }
		 return finalList;
	 }
	 
	 public void traverse(List<Integer> list,TreeNode root) {
		 if(root==null) return;
		 
		 traverse(list, root.left);
		 list.add(root.val);
		 traverse(list, root.right);
		 
	 }
	
}
