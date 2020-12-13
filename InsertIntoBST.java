/*
 		Question:Insert into BST
 		QUestion Code:701
 		Question Category:Medium 
*/
public class InsertIntoBST {

	 public TreeNode insertIntoBST(TreeNode root, int val) {
	         
		 	if(root==null) {
	        	 TreeNode newNode=new TreeNode(val);
	        	 root=newNode;
	        	 return newNode;
	         }
	        
		 	if(root.val>val) {
		 		root.left=insertIntoBST(root.left, val);
		 	}
		 	
		 	if(root.val<val) {
		 		root.right=insertIntoBST(root.right, val);
		 	}
	         
		 	return root;
	 }
	
}
