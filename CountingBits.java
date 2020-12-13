
public class CountingBits {
	
	public static int[] solve(int n) {
		
		int array[]=new int[n+1];
		
		array[0]=0;
		array[1]=1;
		
		for(int i=2;i<=n;i++) {
			array[i]=bitCount(n);
		}
		
		return array;
	}
	
	public static int bitCount(int n) {
		
		int count=0;
		while(n>0) {
			int bit=n%2;
			if(bit==1) {
				count++;
			}
			n=n/2;
		}
		return count;
	}
	
	public static int[] solveDP(int n) {
		int dp[]=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			if(i%2==0) {
				dp[i]=dp[i/2];
			}else {
				dp[i]=dp[i/2]+1;
			}
		}
		return dp;
	}
	
	public static void main(String[] args) {
		
	}
}	
