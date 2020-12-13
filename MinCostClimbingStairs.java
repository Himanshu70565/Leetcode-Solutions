
public class MinCostClimbingStairs {
	
	public static int solve(int cost[],int n) {
		int dp[]=new int[n];
		
		dp[0]=cost[0];
		dp[1]=cost[1];
		
		for(int i=2;i<n;i++) {
			int option1=dp[i-1];
			int option2=dp[i-2];
			dp[i]=Math.min(option1, option2)+cost[i];
		}
		
		
		return dp[n-1];
	}
	
	public static void main(String[] args) {
		
	}
}
