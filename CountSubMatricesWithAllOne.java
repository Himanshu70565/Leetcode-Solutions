
public class CountSubMatricesWithAllOne {
	
	public static int solve(int arr[][],int m,int n) {
		
		int storage[][]=new int[m+1][n+1];
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				storage[i][j]=storage[i][j-1]+arr[i-1][j-1];
			}
		}
		
		for(int j=1;j<=n;j++) {
			for(int i=1;i<=m;i++) {
				storage[i][j]+=storage[i-1][j];
			}
		}
		
		int count=0;
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				
				for(int l=1;l<=m;l++) {
					for(int b=1;b<=n;b++) {
						
						int max_x=i+l-1;
						int max_y=j+b-1;
						
						
						if(max_x<=m&&max_y<=n) {
							
							int sum=storage[max_x][max_y]-storage[i-1][max_y]-storage[max_x][j-1]+storage[i-1][j-1];
							
							if(sum==l*b) {
								count++;
							}
							
							
						}else {
							break;
						}
					}
				}
							
			}
		 }
		
		return count;
		
	}
	
	public static void main(String[] args) {
		
		int arr[][]= {{0,1,1,0},{0,1,1,1},{1,1,1,0}};
		System.out.println(solve(arr, 3, 4));
	}
}
