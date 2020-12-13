import java.util.*;
public class LongestStringChain implements Comparator<String>{
	
	public int compare(String o1, String o2) {
		return o1.length()-o2.length();
	}
	
	public static int solve(String words[]) {
		int n=words.length;
		int dp[]=new int[n];
		
		for(int i=0;i<n;i++) {
			
			String current=words[i];
			dp[i]=1;
			int flag=0;
			
			for(int j=i-1;j>=0;j--) {
				
				int len=words[j].length();
				
				if(len==current.length()) {
					continue;
				}else if(len+1==current.length()) {
					
					while(j>=0&&words[j].length()==len) {
						
						int ans=lcs(current,words[j]);
						if(ans==len) {
							dp[i]=Math.max(dp[j]+1, dp[i]);
						}
						j--;
					}
				}else {
					break;
				}
			}
		}
		
		int max=1;
		for(int i=0;i<n;i++) {
			max=Math.max(max, dp[i]);
		}
		
		return max;
	}
	
    public static int lcs(String s,String t) {
    	
    	int n=s.length();
    	int m=t.length();
    	int dp[][]=new int[n+1][m+1];
    	
    	for(int i=1;i<=n;i++) {
    		for(int j=1;j<=m;j++) {
    			if(s.charAt(i-1)==t.charAt(j-1)) {
    				dp[i][j]=1+dp[i-1][j-1];
    			}else {
    				dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
    			}
    		}
    	}
    	
    	return dp[n][m];
    }
	
	public static void main(String[] args) {
		String words[]= {"ks","kss","czvh","ksqvsyq","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
		Arrays.sort(words,new LongestStringChain());
		System.out.println(solve(words));
	}
}
