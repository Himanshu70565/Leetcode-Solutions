
public class LargestSumOfAverages {
	
//	Recursive Approach  :TLE
	public static double solve(int arr[],int n,int k) {
		
		int prefix[]=new int[n];
		prefix[n-1]=arr[n-1];
		
		for(int i=n-2;i>=0;i--) {
			prefix[i]=prefix[i+1]+arr[i];
		}
		
		return solveHelper(arr,n,prefix,k-1,1,arr[0],1);
	}
	
	public static double solveHelper(int arr[],int n,int prefix[],int k,int index,double total,int count) {
		if(index==n) {
			return total/count;
		}
		
		if(k==0) {
			return (total+prefix[index])/(count+n-index);
		}
		
		double option1=solveHelper(arr, n, prefix, k,index+1, total+arr[index],count+1);
		double option2=0;
		if(k>0) {
		 option2=(double)(total/count)+solveHelper(arr, n, prefix, k-1, index+1, arr[index],1);
		}
		
		return Math.max(option1, option2);
	}
	
//	Passed
	public static double solveDP(int arr[],int n,int k) {
		
		double prefix[]=new double[n];
		prefix[0]=arr[0];
		
		for(int i=1;i<n;i++) {
			prefix[i]=prefix[i-1]+arr[i];
		}
		
		double dp[][]=new double[k][n];
		dp[0][0]=arr[0];
		
		for(int j=1;j<n;j++) {
			dp[0][j]=prefix[j]/(j+1);
		}
		
		for(int i=1;i<k;i++) {
			for(int j=i;j<n;j++) {
				for(int l=0;l<j;l++) {
					dp[i][j]=Math.max(dp[i][j], dp[i-1][l]+(prefix[j]-prefix[l])/(j-l));
				}
			}
		}
		
		return dp[k-1][n-1];
	}
		
	public static void main(String[] args) {
		int arr[]= {9,1,2,3,9};
		System.out.println(solveDP(arr, arr.length, 3));
	}
}
