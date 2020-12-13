/*
 		Leetcode : N-ary Tree Level Order Traversal
 		Question Code : 429
 		Category : Medium
*/
import java.util.*;
public class NaryTreeLevelOrderTraversal {
		
	
	public List<List<Integer>> levelOrder(Node root) {
    
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		if(root==null){
            return list;
        }
		
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			List<Integer> array=new ArrayList<Integer>();
			
			int size=queue.size();
			for(int i=0;i<size;i++) {
				
				Node frontNode=queue.poll();
				array.add(frontNode.val);
				
				for(int j=0;j<frontNode.children.size();j++) {
					queue.add(frontNode.children.get(j));
				}
				
				
			}
			list.add(array);
		}
	
		return list;
    }
}
