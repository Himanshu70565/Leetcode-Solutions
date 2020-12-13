
public class BestTimeToBuyAndSellStocksWithCooldown {
	
//	Recursive 209/211 passed TLE 
	public static int solve(int arr[],int n) {
		return solveHelper(arr,n,0,0,false);
	}
	
	public static int solveHelper(int arr[],int n,int index,int purchase,boolean isGoingOn) {
		
		if(index>=n) {
			return 0;
		}
		
		if(isGoingOn) {
//			Only selling is possible
			
			int option1=(arr[index]-purchase)+solveHelper(arr, n, index+2,0, false);
			int option2=solveHelper(arr, n, index+1,purchase, true);
			return Math.max( option1, option2);
			
		}else {
//			No transaction is going on
			
			int option1=solveHelper(arr, n, index+1, arr[index], true);
			int option2=solveHelper(arr, n, index+1, 0, false);
			
			return Math.max(option1, option2);
		}
	}
	
//	State Transition Approach:
	public static int solveM(int arr[],int n) {
		
		int noStock[]=new int[n];
		int inHand[]=new int[n];
		int sell[]=new int[n];
		
		inHand[0]=-arr[0];
		
		for(int i=1;i<n;i++) {
			
			noStock[i]=Math.max(noStock[i-1], sell[i-1]);
			inHand[i]=Math.max(inHand[i-1], noStock[i-1]-arr[i]);
			sell[i]=inHand[i-1]+arr[i];
		}
		
		
		return Math.max(noStock[n-1],sell[n-1]);
	}
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,0,2};
		System.out.println(solveM(arr, arr.length));
	}
}
