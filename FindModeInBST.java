import java.util.*;
/*
		Question:Find Mode in Binary Search Tree
		Question Code:501
		Question Category:Easy
*/
public class FindModeInBST {
	  
//	  Approach-1:
	  public int[] findMode(TreeNode root) {
	      
		  if(root==null) {
	    	  return new int[0];
	      }
	      
		  Queue<TreeNode> queue=new LinkedList<TreeNode>();
		  HashMap<Integer,Integer> map=new HashMap<>();
		  
		  int maxFreq=0;
		  queue.add(root);
		  
		  while(!queue.isEmpty()) {
			  
			  int size=queue.size();
			  
			  for(int i=0;i<size;i++) {
				  
				  TreeNode frontNode=queue.poll();
				  
				  if(frontNode.left!=null) {
					  queue.add(frontNode.left);
				  }
				  if(frontNode.right!=null) {
					  queue.add(frontNode.right);
				  }
				  
				  if(map.containsKey(frontNode.val)) {
					  int freq=map.get(frontNode.val);
					  map.put(frontNode.val, freq+1);
					  maxFreq=Math.max(maxFreq, freq+1);
				  }else {
					  map.put(frontNode.val, 1);
					  maxFreq=Math.max(maxFreq, 1);
				  }
				  
			  }
			  
		  }
		  
		  Set<Integer> set=map.keySet();
		  Queue<Integer> qu=new LinkedList<Integer>();
		  
		  for(Integer x:set) {
			  int freq=map.get(x);
			  if(freq==maxFreq) {
			     qu.add(x);
			  }
		  }
		  
		 int ans[]=new int[qu.size()];
		 int k=0;
		 while(!qu.isEmpty()) {
			 ans[k++]=qu.poll();
		 }
		 
		 return ans;
	  }
      
	    Integer prev=null;
	    int count=1;
	    int maxCount=0;
	
//	   Approach-2: 	    
	   public int[] findModeApproach2(TreeNode root) {
	        
	        List<Integer> nodes=new ArrayList<Integer>();
	        
	        helper(root,nodes);
	    
	        int ans[]=new int[nodes.size()];
	        for(int i=0;i<nodes.size();i++){
	            ans[i]=nodes.get(i);
	        }
	        
	        return ans;
	    }
	    
	   public void helper(TreeNode root,List<Integer> nodes) {
			  
			  if(root==null) return;
			  
			  helper(root.left,nodes);
			  
	          if(prev!=null){
	              if(prev==root.val){
	                  count++;
	              }else{
	                  count=1;
	              }
	          }
	        
	          if(count>maxCount){
	              maxCount=count;
	              nodes.clear();
	              nodes.add(root.val);
	          }else if(count==maxCount){
	              nodes.add(root.val);
	          }
	        
	          prev=root.val;
	        
	          helper(root.right,nodes);
			  
		  }
	  
}
