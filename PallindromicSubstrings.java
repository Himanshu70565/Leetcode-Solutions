import java.util.*;
public class PallindromicSubstrings {
		
	public static int solveDP(String str) {
		
		int n=str.length();
		int sum=n;
		
		boolean dp[][]=new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				dp[i][j]=true;
			}
		}
		
		for(int i=0;i<n;i++) {
			dp[i][i]=true;
		}
		
		for(int i=n-2;i>=0;i--) {
			for(int j=i+1;j<n;j++) {
				if(str.charAt(i)==str.charAt(j)) {
					
					boolean check=dp[i+1][j-1];
					if(check==true) {
						dp[i][j]=true;
						sum++;
					}
				}
			}
		}
		
		
		return sum;
	}
	
	public static void main(String[] args) {
	
		System.out.println(solveDP("aaa"));
	
	}
}
