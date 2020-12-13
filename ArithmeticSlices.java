import java.util.*;
public class ArithmeticSlices {
	
	public static int solve(int arr[],int n) {
		int count=0;
		
		if(n<=2) {
			return count;
		}
		
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		
		for(int i=1;i<n;i++) {
			int current=arr[i];
			int previous=arr[i-1];
			int diff=current-previous;
			if(map.containsKey(diff)) {
				
				int freq=map.get(diff);
				if(freq==2) {
					map.put(diff, 3);
					count++;
				}else {
					freq++;
					map.put(diff, freq);
					count+=freq-2;
				}
			}else {
				map.clear();
				map.put(diff, 2);
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int arr[]= {1, 2 , 3 ,8 , 9, 10};
		System.out.println(solve(arr,arr.length));
	}
}
