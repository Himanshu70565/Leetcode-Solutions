
public class PredictTheWinner {
	
	public static boolean solve(int arr[],int n) {
		int start=0,end=n-1;
		
		int total=0;
		for(int i=0;i<n;i++) {
			total+=arr[i];
		}
		
		int alice=solveHelper(arr, n, 0 , n-1, 0);
		int lee=total-alice;
		return alice>=lee;
	}
	
	public static int solveHelper(int arr[],int n, int start,int end,int turn) {
		if(start>end) {
			return 0;
		}
		
		if(turn==0) {
			int option1=arr[start];
			int option2=arr[end];
			return Math.max(option1+solveHelper(arr, n, start+1, end, 1),option2+solveHelper(arr, n, start, end-1, 1));
		}else {
			return Math.min(solveHelper(arr, n, start+1, end, 0),solveHelper(arr, n, start, end-1, 0));
		}
		
	}
	
	public static void main(String[] args) {
		
		int arr[]= {1,5,2};
		System.out.println(solve(arr, arr.length));
		
		
	}
}
