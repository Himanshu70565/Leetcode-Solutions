
public class BestTimeToBuyAndSellStock {
	
//	If no of transactions are not bound to 1:
	public static int solve(int arr[],int n) {
		int index=0,flag=0;
		return solveHelper(arr,n,index,0,0,flag);
	}
	public static int solveHelper(int arr[],int n,int index,int total,int purchase,int flag) {
		
		if(index==n-1) {
//			Last Index : 
			if(flag==0) {
				return total;
			}else {
				return total+(arr[index]-purchase);
			}
		
		}
		
//		No transaction is going on
		if(flag==0) {
			
			int option1=solveHelper(arr, n, index+1, total, arr[index], 1);
			int option2=solveHelper(arr, n, index+1,total, 0, 0);
			
			return Math.max(option1, option2);
		}else {
//			Transaction is going on
			
			int option1=solveHelper(arr, n, index+1, total+(arr[index]-purchase),0, 0);
			int option2=solveHelper(arr, n, index+1,total,purchase, 1);
		
			return Math.max(option1, option2);
		}
	}
		
	public static int solveFor1Transaction(int arr[],int n) {
		if(n<=1) {
			return 0;
		}
		int maximum[]=new int[n];
		
		maximum[n-1]=arr[n-1];
		int max=arr[n-1];
		
		for(int i=n-2;i>=0;i--) {
			maximum[i]=max;
			max=Math.max(max, arr[i]);
		}
		
		int diff=0;
		for(int i=0;i<n;i++) {
			diff=Math.max(diff, maximum[i]-arr[i]);
		}
		return diff;
	}
	
	public static void main(String[] args) {
		int arr[]= {7,1,5,3,6,4};
		System.out.println(solve(arr, arr.length));
		
	}	
}
