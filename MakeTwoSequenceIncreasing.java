
public class MakeTwoSequenceIncreasing {
	
//	Wrong Answer:
	public static int solve(int A[],int B[],int n) {
		return solveHelper(A,B,n,0,Integer.MIN_VALUE,Integer.MIN_VALUE);
	}
	
	public static int solveHelper(int A[],int B[],int n,int index,int max_A,int max_B) {
		if(index==n) {
			return 0;
		}
		
		if(max_A>=A[index]||max_B>=B[index]) {
			return 999;
		}
		
		if(A[index]==B[index]) {
			return solveHelper(A, B, n, index+1,A[index],B[index]);
		}
		
		int option1=999;
		
		if(max_A<B[index]&&max_B<A[index]) {
			option1=1+solveHelper(A, B, n, index+1, B[index], A[index]);
		}
		
		int option2=solveHelper(A, B, n, index+1, A[index], B[index]);
		
		System.out.println(index+" "+option1+" "+option2);
		return Math.min(option1,option2);
	}
	
	public static void main(String[] args) {
		int A[]= {3,3,8,9,10};
		int B[]= {1,7,4,6,8};
		
		System.out.println(solve(A, B, A.length));
	}
}
