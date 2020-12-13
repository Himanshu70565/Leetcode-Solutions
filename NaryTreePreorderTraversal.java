import java.util.*;
public class NaryTreePreorderTraversal {
	
	public List<Integer> preorder(Node root) {
		
		List<Integer> list=new ArrayList<Integer>();
		
		if(root==null) {
			return list;
		}
		
		Stack<Node> stack=new Stack<Node>();
		stack.add(root);
		
		while(!stack.isEmpty()) {
				Node frontNode=stack.pop();
				list.add(frontNode.val);
				
				for(int i=frontNode.children.size()-1;i>=0;i--) {
					stack.add(frontNode.children.get(i));
				}
				
		}
		return list;
	}
	
	public List<Integer> postorder(Node root){
		List<Integer> list=new ArrayList<Integer>();
		
		if(root==null) {
			return list;
		}
		
		Stack<Node> stack=new Stack<Node>();
		stack.add(root);
		
		while(!stack.isEmpty()) {
				Node frontNode=stack.pop();
				list.add(frontNode.val);
				
				for(int i=0;i<frontNode.children.size();i++) {
					stack.add(frontNode.children.get(i));
				}
				
		}
		Collections.reverse(list);
		return list;
	}
	

}
