/*
		Question : Sum of Nodes with even value Grandparent
		Question code:1315
		Question category:Medium
*/
import java.util.*;
public class SumOfNodesWithEvenValueGrandParent {
    
	public int sumEvenGrandparent(TreeNode root) {
        return traverse(root, null, null);
    }
    
    public int traverse(TreeNode root,TreeNode parent,TreeNode grandParent){
        
        if(root==null) return 0;
        
        int sum=0;
        
        sum+=traverse(root.left,root,parent);
        sum+=traverse(root.right,root,parent);
        
        if(grandParent!=null&&grandParent.val%2==0){
            sum+=root.val;
        }
        
        return sum;
    }
    
}
