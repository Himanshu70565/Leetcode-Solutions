import java.util.*;
public class BinaryTreePostOrderTraversal {
	
	public static List<Integer> postOrderRecursive(TreeNode root){
		
		List<Integer> list=new ArrayList<Integer>();
		postOrderHelper(root,list);
		return list;
	}
	
	public static void postOrderHelper(TreeNode root,List<Integer> list) {
		
		if(root!=null) {
			postOrderHelper(root.left,list);
			postOrderHelper(root.right,list);
			list.add(root.val);
		}
	}
	
	public static List<Integer> postOrderIteratively(TreeNode root){
		List<Integer> list=new ArrayList<Integer>();
		
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.add(root);
		
		while(!stack.isEmpty()) {
			TreeNode frontNode=stack.pop();
			list.add(frontNode.val);
			
			if(frontNode.left!=null) {
				stack.add(frontNode.left);
			}
			
			if(frontNode.right!=null) {
				stack.add(frontNode.right);
			}
			
		}
		
		 Collections.reverse(list);
		 return list;
	}
	
}
