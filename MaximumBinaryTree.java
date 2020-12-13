
public class MaximumBinaryTree {
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return solveHelper(nums,0,nums.length-1);
    }
	
	public static TreeNode solveHelper(int nums[],int start,int end) {
		
		if(start>end) {
			return null;
		}
		
		int max=nums[start],max_index=start;
		
		for(int i=start;i<=end;i++) {
			if(max<=nums[i]) {
				max=Math.max(max, nums[i]);
				max_index=i;
			}
		}
		
		TreeNode root=new TreeNode(max);
		
		root.left=solveHelper(nums, start, max_index-1);
		root.right=solveHelper(nums, max_index+1, end);
		
		return root;
	}
	
}
