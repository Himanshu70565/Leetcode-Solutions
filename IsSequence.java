
public class IsSequence {
	
//	Recursive
	public static boolean solve(String s,String t) {
		
		if(s.length()==0) {
			return true;
		}
		
		if(t.length()==0) {
			if(s.length()==0) {
				return true;
			}
			return false;
		}
		
		if(s.charAt(0)==t.charAt(0)) {
			return solve(s.substring(1), t.substring(1));
		}else {
			return solve(s, t.substring(1));
		}
	}
	
//	Iterative
	public static boolean solveIterative(String s,String t) {
		if(s.length()==0) {
			return true;
		}
		
		if(t.length()==0) {
			return false;
		}
		
		for(int i=0;i<t.length();i++) {
			if(s.length()==0) {
				return true;
			}
			
			if(t.charAt(i)==s.charAt(0)) {
				s=s.substring(1);
			}
			
		}
		
		if(s.length()==0) {
			return true;
		}
		return false;
	}
	
	//	:> Iterative solution is way faster than the recursive solution
	
	public static void main(String[] args) {
		
	}
}
