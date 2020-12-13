
public class LongestPalindromicSubsequence {
	
	public static int solve(String str) {
		
		int start=0,end=str.length()-1;
		
		return solveHelper(str,start,end);
	}
	
	public static int solveHelper(String str,int start,int end) {
		if(start>end) {
			return 0;
		}
		
		if(start==end) {
			return 1;
		}
		
		if(str.charAt(start)==str.charAt(end)) {
			return 2+solveHelper(str, start+1, end-1);
		}
		
		int option1=solveHelper(str, start, end-1);
		int opiton2=solveHelper(str, start+1, end);
		
		return Math.max(option1, opiton2);
	}
	
	public static int solveM(String str) {

		int start=0,end=str.length()-1;
		int storage[][]=new int[str.length()][str.length()];
		
		for(int i=0;i<str.length();i++) {
			for(int j=0;j<str.length();j++) {
				storage[i][j]=-1;
			}
		}
		return solveHelper(str,storage,start,end);
	}
	
	public static int solveHelper(String str,int storage[][],int start,int end) {
		if(start>end) {
			return 0;
		}
		
		if(start==end) {
			return 1;
		}
		
		if(storage[start][end]!=-1) {
			return storage[start][end];
		}
		
		if(str.charAt(start)==str.charAt(end)) {
			storage[start][end] = 2+solveHelper(str, start+1, end-1);
			return storage[start][end];
		}
		
		int option1=solveHelper(str, start, end-1);
		int opiton2=solveHelper(str, start+1, end);
		
		storage[start][end]=Math.max(option1, opiton2);
		return storage[start][end];
	}
	
	public static int solveDP(String str) {
		
		int n=str.length();
		
		int dp[][]=new int[n+1][n+1];
		
		for(int i=0;i<=n;i++) {
			dp[i][i]=1;
		}
		
		int max=1;
		for(int i=n-1;i>=1;i--) {
			for(int j=i+1;j<=n;j++) {
			
				if(str.charAt(i-1)==str.charAt(j-1)) {
					dp[i][j]=2+dp[i+1][j-1];
				}else {
					int option1=dp[i][j-1];
					int option2=dp[i+1][j];
					dp[i][j]=Math.max(option1, option2);
				}
				
				max=Math.max(dp[i][j], max);
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(solveDP("bbbab"));
	}
}
