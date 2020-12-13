/*
		Question : Delete Node in BST
		Question code : 450 
		Question category: Medium
*/
public class DeleteNodeInBST {
	 
	 public TreeNode deleteNode(TreeNode root, int key) {
	          
		 	  if(root==null) {
	        	  return null;
	          }
	          
		 	  if(root.val>key) {
		 		  root.left=deleteNode(root.left, key);
		 	  }else if(root.val<key) {
		 		  root.right=deleteNode(root.right, key);
		 	  }else {
		 		  
//		 		  Node with no children :leaf node
		 		  if(root.left==null&&root.right==null) {
		 			  return null;
		 		  }
		 		  
//		 		  Node with only single children
		 		  if(root.left==null||root.right==null) {
		 			  return root.left==null ? root.right:root.left;
		 		  }
		 		  
//		 		  Two children
		 		  TreeNode temp=root.left;
		 		  while(temp.right!=null) {
		 			  temp=temp.right;
		 		  }
		 		  
		 		  root.val=temp.val;
		 		  root.left=deleteNode(root.left, temp.val);
		 		  return root;
		 		  
		 	  }
		 	  
	         return root;
	 }
}
