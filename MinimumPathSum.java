
public class MinimumPathSum {
	
	public static int solve(int arr[][],int m,int n) {
		
		int dp[][]=new int[m][n];
		
		dp[m-1][n-1]=arr[m-1][n-1];
		
		for(int j=n-2;j>=0;j--) {
			dp[m-1][j]=dp[m-1][j+1]+arr[m-1][j];
		}
		
		for(int i=m-2;i>=0;i--) {
			dp[i][n-1]=dp[i+1][n-1]+arr[i][n-1];
		}
		
		for(int i=m-2;i>=0;i--) {
			for(int j=n-2;j>=0;j--) {
				dp[i][j]=Math.min(dp[i][j+1],dp[i+1][j])+arr[i][j];
			}
		}
		
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		
	}
}
