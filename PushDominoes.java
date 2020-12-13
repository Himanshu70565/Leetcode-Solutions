
public class PushDominoes {
	
	public static String solve(String str) {
		
		int N=str.length();
		int forces[]=new int[N];
		
		int force=0; 
		for(int i=0;i<N;i++) {
				if(str.charAt(i)=='R') {
					force=N;
				}else if(str.charAt(i)=='L') {
					force=0;
				}else {
					force=Math.max(force-1, 0);
				}
				forces[i]=force;
		}
		
		force=0;
		for(int i=N-1;i>=0;i--) {
			if(str.charAt(i)=='L') {
				force=N;
			}else if(str.charAt(i)=='R') {
				force=0;
			}else {
				force=Math.max(force-1, 0);
			}
			forces[i]-=force;
		}
		
		String ans="";
		for(int i=0;i<N;i++) {
			if(forces[i]==0) {
				ans+=".";
			}else if(forces[i]>0) {
				ans+="R";
			}else {
				ans+="L";
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(solve(".L.R...LR..L.."));
	}
}
