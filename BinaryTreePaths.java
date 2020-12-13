import java.util.*;
public class BinaryTreePaths {
	
    public List<String> binaryTreePaths(TreeNode root) {
        
    	List<String> list=new ArrayList<String>();
		binaryTreePathsHelper(root,list,""); 
		return list;
	}
	
	public static void binaryTreePathsHelper(TreeNode root,List<String> list,String str){
		if(root==null){
            return ;
        }
     
		if(root.left==null&&root.right==null){
            str+=root.val;
            list.add(str);
            return;
        }
        
		
		str+=root.val+"->";
        if(root.left!=null){
            binaryTreePathsHelper(root.left, list, str);    
        }
        
        if(root.right!=null){
            binaryTreePathsHelper(root.right, list, str);    
        }
		
	}
	
}
