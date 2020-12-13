import java.util.*;
public class PerfectSquare {
	
	public static int solve(int n) {
		int dp[]=new int[n+1];
		
		dp[1]=1;
		
		for(int i=1;i<=n;i++) {
			
			dp[i]=Integer.MAX_VALUE;
			
			for(int j=(int)Math.sqrt(i);j>=1;j--) {
				
				dp[i]=Math.min(dp[i], 1+dp[i-j*j]);
				
			}
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		System.out.println(solve(13));
	}
}
