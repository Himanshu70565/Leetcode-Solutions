
public class SumRootToLeafNumbers {
	
	public int sumNumbers(TreeNode root) {
		return sumNumbersHelper(root,0);
	}
	
	public static int sumNumbersHelper(TreeNode root,int num) {
		
//		Base case
		if(root==null) {
			return 0;
		}
		
//		If we reached the leaf node : 
		if(root.left==null&&root.right==null) {
			num=num*10+root.val;
			return num;
		}
		
		num=num*10+root.val;
		
		int leftAns=sumNumbersHelper(root.left,num);
		int rightAns=sumNumbersHelper(root.right, num);
		
		return leftAns+rightAns;
	}
	  
}
