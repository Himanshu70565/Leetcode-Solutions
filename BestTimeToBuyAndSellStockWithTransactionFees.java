
public class BestTimeToBuyAndSellStockWithTransactionFees {

//	Recursive Approach giving TLE	
	public static int solve(int arr[],int n,int fee) {
		int index=0,flag=0;
		return solveHelper(arr,n,index,0,0,flag,fee);
	}
	
	public static int solveHelper(int arr[],int n,int index,int total,int purchase,int flag,int fee) {
		
		if(index==n-1) {
//			Last Index : 
			if(flag==0) {
//				System.out.println(total);
				return total;
			}else {
				return total+(arr[index]-purchase-fee);
			}
		
		}
		
//		No transaction is going on
		if(flag==0) {
			
			int option1=solveHelper(arr, n, index+1, total, arr[index], 1, fee);
			int option2=solveHelper(arr, n, index+1,total, 0, 0, fee);
			
			return Math.max(option1, option2);
		}else {
//			Transaction is going on
			
			int option1=solveHelper(arr, n, index+1, total+(arr[index]-purchase-fee),0, 0 ,fee);
			int option2=solveHelper(arr, n, index+1,total,purchase, 1 ,fee);
		
			return Math.max(option1, option2);
		}
	}
	
//	State Selection Mode
	public static int solveM(int arr[],int n,int T) {
		
		
		int noStock[]=new int[n];
		int inHand[]=new int[n];
		int sell[]=new int[n];
		
		inHand[0]=-arr[0];
		
		for(int i=1;i<n;i++) {
			
			noStock[i]=Math.max(noStock[i-1],sell[i-1]);
			inHand[i]=Math.max(inHand[i-1], Math.max(noStock[i-1]-arr[i],sell[i-1]-arr[i]));
			sell[i]=inHand[i-1]+arr[i]-T;
		}
		
		return Math.max(noStock[n-1], sell[n-1]);
	}
	
	public static void main(String[] args) {
	
		int arr[]={1, 3, 2, 8, 4, 9};
		System.out.println(solveM(arr, arr.length, 2));
		
	}
}
