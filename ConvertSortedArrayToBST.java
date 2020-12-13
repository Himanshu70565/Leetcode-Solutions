/*
		Question : Convert Sorted Array TO BST
		Question Code:108
		Question Category: Easy
*/
public class ConvertSortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] nums) {
            return helperFunction(nums,0,nums.length-1);    
    }
	
	public static TreeNode helperFunction(int nums[],int start,int end) {
		
		if(start>end) {
			return null;
		}
		
		int mid=(start+end)/2;
		
		TreeNode root=new TreeNode(nums[mid]);
		
		root.left=helperFunction(nums, start, mid-1);
		root.right=helperFunction(nums, mid+1, end);
		
		return root;
	}
	
}
