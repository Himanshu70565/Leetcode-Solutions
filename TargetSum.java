import java.util.*;
public class TargetSum {
	
	public static int solve(int arr[],int n,int target) {
		return solveHelper(arr,n,0,0,target);
	}
	
	public static int solveHelper(int arr[],int n,int index,int sum,int target) {
		if(index==n) {
			if(target==sum) {
				return 1;
			}
			return 0;
		}
		
		int option1=solveHelper(arr, n, index+1, sum-arr[index],target);
		int option2=solveHelper(arr, n, index+1, sum+arr[index],target);
		
		return option1+option2;
	}
	
	public static int solveM(int arr[],int n,int target) {
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		return solveHelper(arr, n, 0,target,map);
	}
	
	public static int solveHelper(int arr[],int n,int index,int target,HashMap<String,Integer> map) {
		if(index==n) {
			if(target==0) {
				return 1;
			}
			return 0;
		}
		
		if(map.containsKey(index+":"+target)) {
			return map.get(index+":"+target);
		}
		
		int option1=solveHelper(arr, n, index+1, target-arr[index], map);
		int option2=solveHelper(arr, n, index+1, target+arr[index], map);
		
		int ways=option1+option2;
		map.put(index+":"+target, ways);
		return ways;
	}
	
	public static void main(String[] args) {
		int arr[]= {1,1,1,1,1};
		int n=arr.length;
		System.out.println(solveM(arr, n, 3));
	}
}
