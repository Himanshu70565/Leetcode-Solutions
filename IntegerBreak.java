
public class IntegerBreak {
	
	public static int solve(int n) {
		
		int dp[]=new int[n+1];
		
		dp[1]=0;
		dp[2]=1;
		
		for(int i=3;i<=n;i++) {
			for(int j=1;j<=i/2;j++) {
				int num1=j;
				int num2=i-j;
				
				dp[i]=Math.max(dp[i], Math.max(num1, dp[num1])*Math.max(dp[num2], num2));
			}
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		System.out.println(solve(10));
	}
}
