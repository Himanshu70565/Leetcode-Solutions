import java.util.*;
class Sample implements Comparator<Sample>{
	int first,second;
	
	public Sample(int first,int second) {
		this.first=first;
		this.second=second;
	}

	public Sample() {	
	}
	
	@Override
	public int compare(Sample o1, Sample o2) {
		return o1.first-o2.first;
	}
}
public class MaximumLengthOfPairChain {
	
	public static int solve(int arr[][],int n) {
		if(n==0) {
			return 0;
		}
		
		
		Sample array[]=new Sample[n];
		
		for(int i=0;i<n;i++) {
			array[i]=new Sample(arr[i][0],arr[i][1]);
		}
		
		Arrays.sort(array,new Sample());
		
		int dp[]=new int[n];
		
		for(int i=0;i<n;i++) {
				dp[i]=1;
			for(int j=i-1;j>=0;j--) {
				if(array[j].second<array[i].first) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int max=1;
		for(int i=0;i<n;i++) {
			max=Math.max(max,dp[i]);
		}
		
		return max;
	}
	public static void main(String[] args) {
		int arr[][]= {{3,4},{1,2},{2,3}};
		System.out.println(solve(arr, arr.length));
	}
}
