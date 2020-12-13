
public class CostructTreeFromInorderAndPreorder {
	
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
	        return solve(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
	 }
	 
	 public TreeNode solve(int[] preorder,int[] inorder,int s_preorder,int e_preorder,int s_inorder,int e_inorder) {
		 if(s_preorder>e_preorder||s_inorder>e_inorder) {
			 return null;
		 }
		 
		 TreeNode root=new TreeNode(preorder[s_preorder]);
		 
		 int pos=-1;
		 for(int i=s_inorder;i<=e_inorder;i++) {
			 if(inorder[i]==root.val) {
				 pos=i;
				 break;
			 }
		 }
		 
		 int start_leftSubtreeInorder=s_inorder;
		 int end_leftSubtreeInorder=pos-1;
		 int start_rightSubtreeInorder=pos+1;
		 int end_rightSubtreeInorder=e_inorder;
		 
		 int start_leftSubtreePreorder=s_preorder+1;
		 int end_leftSubtreePreorder=s_preorder+1+end_leftSubtreeInorder-start_leftSubtreeInorder;		 
		 int start_rightSubtreePreorder=end_leftSubtreePreorder+1;
		 int end_rightSubtreePreorder=e_preorder;
		 
		 root.left=solve(preorder, inorder, start_leftSubtreePreorder, end_leftSubtreePreorder, start_leftSubtreeInorder,end_leftSubtreeInorder);
		 root.right=solve(preorder, inorder, start_rightSubtreePreorder, end_rightSubtreePreorder, start_rightSubtreeInorder,end_rightSubtreeInorder);
		 
		 return root;
	 }
	 
}
