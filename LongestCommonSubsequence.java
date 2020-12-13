
public class LongestCommonSubsequence {
	
	public static int solve(String s,String t) {
	
		if(s.length()==0||t.length()==0) {
			return 0;
		}
		
		if(s.charAt(0)==t.charAt(0)) {
			return 1+solve(s.substring(1), t.substring(1));
		}
		
		int option1=solve(s, t.substring(1));
		int option2=solve(s.substring(1), t);
		
		return Math.max(option1, option2);
	
	}

    public static int solveM(String s,String t){
        
        int n=s.length();
        int m=t.length();
        
        int storage[][]=new int[n+1][m+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                storage[i][j]=-1;
            }
        }
    
        return solveHelper(s,t,storage);
    }
    
    public static int solveHelper(String s,String t,int storage[][]){
    
        int n=s.length();
        int m=t.length();
        
        if(n==0||m==0){
            return 0;
        }
        
        if(storage[n][m]!=-1){
            return storage[n][m];
        }
        
    	if(s.charAt(0)==t.charAt(0)) {
			storage[n][m]= 1+solve(s.substring(1), t.substring(1));
			return storage[n][m];
    	}
		
		int option1=solve(s, t.substring(1));
		int option2=solve(s.substring(1), t);
		
		storage[n][m]= Math.max(option1, option2);
	    return storage[n][m];
    }
	
    public static int solveDP(String s,String t) {
    	
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
		System.out.println(solveDP("abcde", "ace"));
	}
}
