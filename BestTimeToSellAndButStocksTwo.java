
public class BestTimeToSellAndButStocksTwo {
	
	public static int solveM(int arr[],int 	n) {
		
		
		int noStock[]=new int[n];
		int inHand[]=new int[n];
		int sell[]=new int[n];
		
		inHand[0]=-arr[0];
		
		for(int i=1;i<n;i++) {
			
			noStock[i]=Math.max(noStock[i-1],sell[i-1]);
			inHand[i]=Math.max(inHand[i-1], Math.max(noStock[i-1]-arr[i],sell[i-1]-arr[i]));
			sell[i]=inHand[i-1]+arr[i];
		}
		
		return Math.max(noStock[n-1], sell[n-1]);
	}
	
	public static void main(String[] args) {
		
	}
}
