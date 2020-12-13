
public class MinimumAsciiDeleteSumForTwoStrings {
	
	public static int solve(String s,String t) {
	
		if(s.length()==0) {
			int sum=0;
			for(int i=0;i<t.length();i++) {
				sum+=t.charAt(i);
			}
			return sum;
		}
		
		if(t.length()==0) {
			int sum=0;
			for(int i=0;i<s.length();i++) {
				sum+=s.charAt(i);
			}
			return sum;
		}
		
		if(s.charAt(0)==t.charAt(0)) {
			return solve(s.substring(1),t.substring(1));
		}
		
		int option1=s.charAt(0)+solve(s.substring(1), t);
		int option2=t.charAt(0)+solve(s, t.substring(1));
		int option3=s.charAt(0)+t.charAt(0)+solve(s.substring(1),t.substring(1));
		
		
		return Math.min(option1, Math.min(option2, option3));
	}

	public static int solveM(String s,String t) {
		
		int n=s.length();
		int m=t.length();
		int storage[][]=new int[n+1][m+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				storage[i][j]=-1;
			}
		}
		
		return solveHelper(s,t,storage);
	}
	
	public static int solveHelper(String s,String t,int storage[][]) {
		int n=s.length();
		int m=t.length();
		
		if(storage[n][m]!=-1) {
			return storage[n][m];
		}
		
		if(n==0) {
			int sum=0;
			for(int i=0;i<m;i++) {
				sum+=t.charAt(i);
			}
			storage[n][m]=sum;
			return storage[n][m];
		}
		
		if(m==0) {
			int sum=0;
			for(int i=0;i<n;i++) {
				sum+=s.charAt(i);
			}
			storage[n][m]=sum;
			return storage[n][m];
		}
		
		if(s.charAt(0)==t.charAt(0)) {
			storage[n][m]=solve(s.substring(1),t.substring(1));
			return storage[n][m];
		}
		
		int option1=s.charAt(0)+solveHelper(s.substring(1), t,storage);
		int option2=t.charAt(0)+solveHelper(s, t.substring(1),storage);
		int option3=s.charAt(0)+t.charAt(0)+solveHelper(s.substring(1),t.substring(1),storage);
		
		
		storage[n][m]=Math.min(option1, Math.min(option2, option3));
		return storage[n][m];
	}
	
	public static int solveDP(String s,String t) {
		
		int n=s.length();		
		int m=t.length();
		
		int dp[][]=new int[n+1][m+1];
	
		for(int j=1;j<=m;j++) {
			dp[0][j]=dp[0][j-1]+t.charAt(j-1);
		}
		
		for(int i=1;i<=n;i++) {
			dp[i][0]=dp[i-1][0]+s.charAt(i-1);
		}
		
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				
				if(s.charAt(i-1)==t.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1];
				}else {
					int option1=s.charAt(i-1)+dp[i-1][j];
					int option2=t.charAt(j-1)+dp[i][j-1];
					
					dp[i][j]=Math.min(option1, option2);
				}
			}
		}
		
		
		return dp[n][m];
	}
	
	public static void main(String[] args) {
		System.out.println(solveDP("delete", "leet"));
	}
}
