import java.util.*;

public class GreatestSumDivisibleByThree {
	
	public static int solve(int arr[],int num) {
		
		ArrayList<Integer> one=new ArrayList<Integer>();
		ArrayList<Integer> two=new ArrayList<Integer>();
		
		int sum=0;
		
		for(int i=0;i<num;i++) {
			if(arr[i]%3==0) {
				sum+=arr[i];
			}
			if(arr[i]%3==1) {
				one.add(arr[i]);
			}
			if(arr[i]%3==2) {
				two.add(arr[i]);
			}
		}
		
		Collections.sort(one,Collections.reverseOrder());
		Collections.sort(two,Collections.reverseOrder());
		
		
		int n=one.size();
		int m=two.size();
		
		int storage[][]=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				storage[i][j]=-1;
			}
		}
		
		
		int result=solveHelper(one, two, storage, 0, 0);
		return sum+result;
	}
	
	public static int solveHelper(ArrayList<Integer> one,ArrayList<Integer> two,int storage[][],int i,int j) {
		
		if(i>=one.size()) {
			int sum=0;
			for(int k=j;k<two.size();k=k+3) {
			
				if(k+2<two.size()) {
					sum+=two.get(k)+two.get(k+1)+two.get(k+2);
				}else {
					break;
				}
			
			}
			return sum;
		}
		
		if(j>=two.size()) {
			int sum=0;
			for(int k=i;k<one.size();k=k+3) {
			
				if(k+2<one.size()) {
					sum+=one.get(k)+one.get(k+1)+one.get(k+2);
				}else {
					break;
				}
			
			}
			return sum;
		}
		
		if(storage[i][j]!=-1) {
			return storage[i][j];
		}
		
//		1 and 2 pair
		int option1=one.get(i)+two.get(j)+solveHelper(one, two, storage, i+1, j+1);
		
		int option2=Integer.MIN_VALUE,option3=Integer.MIN_VALUE;
		
		if(i+2<one.size()) {
			option2=one.get(i)+one.get(i+1)+one.get(i+2)+solveHelper(one, two, storage, i+3, j);
		}
		
		if(j+2<two.size()) {
			option3=two.get(j)+two.get(j+1)+two.get(j+2)+solveHelper(one, two, storage, i, j+3);
		}
		
		storage[i][j]=Math.max(option1, Math.max( option2, option3));
		return storage[i][j];
	}
	
	public static void main(String[] args) {
		
		int arr[]= {5,2,2,2};
		System.out.println(solve(arr, arr.length));
		
	}
}
