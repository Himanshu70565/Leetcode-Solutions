import java.util.HashMap;

public class NumberOfLongestIncreasingSubsequence {
	
	public static int solve(int arr[],int n) {
		
//		Longest length subsequence
		int dp[]=new int[n];
		
//		Number of subsequence ends at given number with max length
		int count[]=new int[n];
		
		int max=1;
		for(int i=0;i<n;i++) {
			dp[i]=1;
			count[i]=1;
			for(int j=i-1;j>=0;j--) {
				if(arr[j]<arr[i]) {
					
					if((dp[j]+1)>dp[i]) {
						dp[i]=Math.max(dp[i], dp[j]+1);
						max=Math.max(max, dp[i]);
						count[i]=count[j];
					}else if((dp[j]+1)==dp[i]){
						count[i]+=count[j];
						max=Math.max(max, dp[i]);
					}
				
				}
			}
		}
		
		int counts=0;
		for(int i=0;i<n;i++) {
			if(dp[i]==max) {
				counts+=count[i];
			}
		}
		
		
		return counts;
	}
	
	public static void main(String[] args) {
		int arr[]= {1,2,4,3,5,4,7,2};
		System.out.println(solve(arr, arr.length));
	}
}
