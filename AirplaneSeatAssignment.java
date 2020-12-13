
public class AirplaneSeatAssignment {
	
	public static double solve(int n) {
		if(n==1) {
			return 1.0;
		}
		
		return 0.5;
	}
		
	public static void main(String[] args) {
		System.out.println(solve(2));
	}
}
