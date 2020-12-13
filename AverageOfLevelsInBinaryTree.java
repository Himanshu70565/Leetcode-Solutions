import java.util.*;
public class AverageOfLevelsInBinaryTree {
	
	public List<Double> averageOfLevels(TreeNode root) {
	        List<Double> list=new ArrayList<Double>();
	        
	        Queue<TreeNode> queue=new LinkedList<TreeNode>();
	        queue.add(root);
	        
	        while(!queue.isEmpty()) {
	        	int size=queue.size();
	        	double ans=0;
	        	
	        	for(int i=0;i<size;i++) {
	        		
	        		TreeNode frontNode=queue.poll();
	        		ans+=frontNode.val;
	        		
	        		if(frontNode.left!=null) {
	        			queue.add(frontNode.left);
	        		}
	        		
	        		if(frontNode.right!=null) {
	        			queue.add(frontNode.right);
	        		}
	        		
	        	}
	        	list.add(ans/size);
	        }
	        
	        
	        return list;
	}
	
}
