
public class DivisorGame {
	
	public static boolean solve(int n) {
		boolean cache[]=new boolean[n];
		return solveM(n,cache);
	}
	
	public static boolean solveM(int n,boolean cache[]) {
		if(n<=1) {
			return false;
		}
		
		if(cache[n]==true) {
			return cache[n];
		}
		
		for(int i=1;i<n;i++) {
			if(n%i==0) {
				boolean ans=solveM(n-i,cache);
				if(ans==false) {
					cache[n]=true;
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(solve(2));
	}
}
