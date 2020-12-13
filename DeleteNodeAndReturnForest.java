/*
 		Leetcode : Delete Node and Return Forest
 		Question Code : 1110
 		Category : Medium
*/
import java.util.*;
public class DeleteNodeAndReturnForest {
   
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        Arrays.sort(to_delete);
		List<TreeNode> list=new ArrayList<>();
		solve(root,to_delete,list);	
		
        if(Arrays.binarySearch(to_delete,root.val)<0){
            list.add(root);
        }
        
        return list;
    
    }
	
	public TreeNode solve(TreeNode root,int[] to_delete,List<TreeNode> list) {
		if(root==null) {
			return null;
		}
		
		root.left=solve(root.left, to_delete, list);
		root.right=solve(root.right, to_delete, list);
		
		if(Arrays.binarySearch(to_delete, root.val)>=0) {
			if(root.left!=null) {
				list.add(root.left);
			}
			
			if(root.right!=null) {
				list.add(root.right);
			}
			
			return null;
		}
		
		return root;
	}
	
}
