import java.util.HashMap;
class Pair{
	HashMap<Integer,Integer> map;
	public Pair() {
		map=new HashMap<Integer, Integer>();
	}
}
public class LongestArithmeticSubsequence {
	
	public static int solve(int arr[],int n) {
		
		Pair dp[]=new Pair[n];
		int max=1;
		
		for(int i=0;i<n;i++) {
			dp[i]=new Pair();
			
			for(int j=i-1;j>=0;j--) {
				
				int diff=arr[i]-arr[j];
				
				if(dp[j].map.containsKey(diff)) {
					
					int freq_j=dp[j].map.get(diff);
					
					if(dp[i].map.containsKey(diff)) {
						int freq_i=dp[i].map.get(diff);
						dp[i].map.put(diff, Math.max(freq_j+1, freq_i));
					}else {
						dp[i].map.put(diff, freq_j+1);
					}
							
				}else {
					dp[i].map.put(diff, 2);
				}
				
			}
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(dp[i].map);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int arr[]= {22,0,0,0,0,0,10,35,39,12,15,6,35};
		System.out.println(solve(arr,arr.length));
	}
}
