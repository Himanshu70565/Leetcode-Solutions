
public class MaximumSubarray {
	
//	O(n2)
	public static int solve(int arr[],int n) {
		
		int sum=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			int total=0;
			for(int j=i;j<n;j++) {
				total+=arr[j];
				if(total>sum) {
					sum=total;
				}
			}
		}
		
		return sum;
		
	}

//	O(n)
	public static int solveImproved(int arr[],int n) {
		
		if(n==0) {
			return 0;
		}
		
		int current=arr[0];
		int global=arr[0];
		
		
		for(int i=1;i<=n;i++) {
			int option1=current+arr[i];
			int option2=arr[i];
			
			current=Math.max(option1, option2);
			global=Math.max(current, global);
		}
		
		return global;
	}
	
	public static void main(String[] args) {
		
		
		
	}
}
