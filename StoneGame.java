
public class StoneGame {
	
	public static boolean solve(int arr[],int n) {
		return solveHelper(arr, 0, n-1, 0, 0,0);
	}

	public static boolean solveHelper(int arr[],int start,int end,int alice,int lee,int flag) {
		if(start==end) {
			if(flag==0) {
//				Alice
				
				if(alice+arr[start]>lee) {
					return true;
				}
				
				return false;
				
			}else {
//				Lee
				if(lee+arr[start]>alice) {
					return false;
				}
				
				return true;
			}
		}
		
		
		if(flag==0) {
//			Alice turn
			
//			Alice start
			boolean option1=solveHelper(arr, start+1, end, alice+arr[start], lee, 1);
			boolean option2=solveHelper(arr, start, end-1, alice+arr[end], lee, 1);
			
			if(option1==true||option2==true) {
				return true;
			}
			
		}else {
//			Lee Turn
			boolean option1=solveHelper(arr, start+1, end, alice, lee+arr[start], 0);
			boolean option2=solveHelper(arr, start, end-1, alice, lee+arr[end], 0);
			
			if(option1==true||option2==true) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int arr[]= {3,7,2,3};
		System.out.println(solve(arr, arr.length));
		
		
	}
}
