import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MinimumCostForTickets {
	
//	Even memoization is giving tle
	public static int solveM(int arr[],int cost[],int n) {
		
		Arrays.sort(arr);
		int frequency[]=new int[366];
		int storage[]=new int[366];
		
		for(int i=0;i<=365;i++) {
			storage[i]=-1;
		}
		
		for(int i=0;i<n;i++) {
			frequency[arr[i]]++;
		}
		
		return solveHelper(cost,frequency,storage,arr[0]);
	}
	
	public static int solveHelper(int cost[],int frequency[],int storage[],int start) {
		
		if(start>=366) {
			return 0;
		}
		
		if(storage[start]!=-1) {
			return storage[start];
		}
		
		if(frequency[start]==0) {
			while(start<=365&&frequency[start]!=1) {
				start++;
			}
			if(start>=366) {
				return 0;
			}
		}
		
		int option1=cost[0]+solveHelper(cost, frequency, storage, start+1);
		int option2=cost[1]+solveHelper(cost, frequency, storage, start+7);
		int option3=cost[2]+solveHelper(cost, frequency, storage, start+30);
		
		storage[start]= Math.min(option1, Math.min(option2, option3));
		return storage[start];
	}

	public static int solveDP(int arr[],int cost[],int n) {
		
		int dp[]=new int[366];
		
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++) {
			map.put(arr[i], 1);
		}
		
		for(int i=365;i>=1;i--) {
			if(map.containsKey(i)) {
				 
				int option1=cost[0],option2=Integer.MAX_VALUE,option3=Integer.MAX_VALUE;
				if(i+1<=365) {
					option1+=dp[i+1];
				}
				
				if(i+7<=365) {
					option2=cost[1]+dp[i+7];
				}
				
				if(i+30<=365) {
					option3=cost[2]+dp[i+30];
				}
				
				dp[i]=Math.min(option1, Math.min(option2, option3));
			}else {
				if(i+1<=365) {
					dp[i]=dp[i+1];
				}
			}
		}
		
		return dp[1];
	}
	
	public static void main(String[] args) {
		int arr[]=  {1,2,3,4,5,6,7,8,9,10,30,31};
		int cost[] = {2,7,15};
		
		System.out.println(solveDP(arr, cost, arr.length));
		
	}
}
