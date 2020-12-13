
public class LongestPalindromicSubstring {
	
	public static String solveDP(String str) {
		
		int n=str.length();
		
		if(n==0) {
			return "";
		}
		
		int dp[][]=new int[n][n];
		
		for(int i=0;i<n;i++) {
			dp[i][i]=1;
		}
		
		
		int max=1;
		String ans=str.charAt(0)+"";
		
		for(int i=n-2;i>=0;i--) {
			for(int j=i+1;j<n;j++) {
				if(str.charAt(i)==str.charAt(j)) {
					if(dp[i+1][j-1]!=0||Math.abs(j-i)==1) {
						dp[i][j]=2+dp[i+1][j-1];
						if(dp[i][j]>max) {
							max=dp[i][j];
							ans=str.substring(i,j+1);
						}
					}
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		
	}
}
