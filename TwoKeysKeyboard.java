
public class TwoKeysKeyboard {
	
	public static int solve(int n) {
		if(isPrime(n)) {
			return n;
		}
		
		if(n%2==0) {
			return 2+solve(n/2);
		}else {
		
			int result=n;
			for(int i=n-1;i>=1;i--) {
				if(n%i==0) {
					result=Math.min(result, solve(i)+(n/i));
				}
			}
			return result;
		}	
	}
	
	public static boolean isPrime(int n) {
		if(n==1) {
			return false;
		}
		int count=0;
		for(int i=2;i<n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(solve(27));
	}
}
