
public class MaximumLengthOfRepeatedSubarray {
	
//	TLE
	public static int solve(int A[],int B[]) {
		return solveHelper(A,B,0,0);
	}
	
	public static int solveHelper(int A[],int B[],int i,int j) {
		
		int n=A.length;
		int m=B.length;
		
		if(i>=n||j>=m) {
			return 0;
		}
		
		int option1=solveHelper(A, B, i+1, j);
		int option2=solveHelper(A, B, i, j+1);
		int option3=0;
		
		if(A[i]==B[j]) {
			int count=0;
			while(i<n&&j<m&&A[i]==B[j]) {
				count++;
				i++;
				j++;
			}
			option3=Math.max(count,solveHelper(A, B, i, j));
		}
		
		return Math.max(option1, Math.max(option2, option3));
	}
	
//	TLE
	public static int solveM(int A[],int B[]) {
		int n=A.length;
		int m=B.length;
		
		int storage[][]=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				storage[i][j]=-1;
			}
		}
		return solveHelper(A, B,storage, 0, 0);
	}
	
	public static int solveHelper(int A[],int B[],int storage[][],int i,int j) {
		
		int n=A.length;
		int m=B.length;
		
		if(i>=n||j>=m) {
			return 0;
		}
		
		if(storage[i][j]!=-1) {
			return storage[i][j];
		}
		
		int option1=solveHelper(A, B, i+1, j);
		int option2=solveHelper(A, B, i, j+1);
		int option3=0;
		
		if(A[i]==B[j]) {
			int count=0;
			while(i<n&&j<m&&A[i]==B[j]) {
				count++;
				i++;
				j++;
			}
			option3=Math.max(count,solveHelper(A, B, i, j));
		}
		
		storage[i][j]=Math.max(option1, Math.max(option2, option3));
		return storage[i][j];
	}
	
//	Accepted DP Solution
	public static int solveDP(int A[],int B[]) {
		
		int n=A.length;
		int m=B.length;
		
		int dp[][]=new int[n+1][m+1];
		
		int max=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(A[i-1]==B[j-1]) {
					dp[i][j]=1+dp[i-1][j-1];
					max=Math.max(max, dp[i][j]);
				}
			}
		}
		
		
		
		return max;
	}
	
	public static void main(String[] args) {
		int a[]= {0,0,0,0,0,0,1,0,0,0};
		int b[]= {0,0,0,0,0,0,0,1,0,0};
		System.out.println(solveDP(a, b));
	}
}
