
public class HouseRobber {
	
	public static int solve(int arr[],int n) {
		return solveHelper(arr,0,n);
	}
	
	public static int solveHelper(int arr[],int start,int n) {
		
		if(start>=n) {
			return 0;
		}
		
		int option1=arr[start]+solveHelper(arr, start+2, n);
		int option2=solveHelper(arr, start+1, n);
	
		return Math.max(option1, option2);
	}
	
	public static int solveDP(int arr[],int n) {
		
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return arr[0];
		}
		
		int dp[]=new int[n];
		dp[0]=arr[0];
		dp[1]=Math.max(arr[0], arr[1]);
		
		for(int i=2;i<n;i++) {
			dp[i]=Math.max(dp[i-1], arr[i]+dp[i-2]);
		}
		
		return dp[n-1];
	}
	
	public static void main(String[] args) {
		int arr[]= new int[0];
		System.out.println(arr.length);
	}
}
