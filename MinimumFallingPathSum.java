
public class MinimumFallingPathSum {
	
	public static int solve(int arr[][],int n) {
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<n;j++) {
				
				int option1=Integer.MAX_VALUE,option2=arr[i-1][j],option3=Integer.MAX_VALUE;
				
				if(j-1>=0) {
					option1=arr[i-1][j-1];
				}
				
				if(j+1<n) {
					option3=arr[i-1][j+1];
				}
				
				arr[i][j]=Math.min(option1, Math.min(option2, option3))+arr[i][j];
			}
		}
		
		int minimum=Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			minimum=Math.min(minimum, arr[n-1][i]);
		}
		
		return minimum;
	}
	
	public static void main(String[] args) {
		
	}
}
