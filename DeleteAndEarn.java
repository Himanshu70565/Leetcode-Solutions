import java.util.*;

public class DeleteAndEarn {

	public static int solveDP(int arr[],int n) {
		if(n==0) {
			return 0;
		}
		int MAX=10000;
		int frequency[]=new int[MAX];
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		for(int i=0;i<n;i++) {
			if(frequency[arr[i]]==0) {
				list.add(arr[i]);
			}
			frequency[arr[i]]++;
		}
		
		Collections.sort(list);
		int dp[]=new int[list.size()];
		dp[0]=list.get(0)*frequency[list.get(0)];
		
		for(int i=1;i<list.size();i++) {
			
			int current=list.get(i);
			int option1=dp[i-1];
			int option2=current*frequency[current];
			
			int j=i-1;
			while(j>=0) {
				if((list.get(j)+1)==current) {
					j--;
				}else {
					option2+=dp[j];
					break;
				}
			}
			
			dp[i]=Math.max(option1, option2);
		}
		
		
		
		return dp[list.size()-1];
	}
	
	public static void main(String[] args) {
		int arr[]= {4,10,10,8,1,4,10,9,7,6};
		System.out.println(solveDP(arr,arr.length));
	}
}
