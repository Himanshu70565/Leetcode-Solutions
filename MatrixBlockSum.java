import java.util.*;
public class MatrixBlockSum {
	
	public static int[][] solve(int matrix[][],int k) {
		
		int n=matrix.length-1;
		int m=matrix[0].length-1;
		
		int answer[][]=new int[n+1][m+1];
		
		int sum[][]=new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				sum[i][j]=matrix[i][j];
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				sum[i][j]+=sum[i][j-1];
			}
		}
		
		for(int j=1;j<=m;j++) {
			for(int i=1;i<=n;i++) {
				sum[i][j]+=sum[i-1][j];
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				
				int max_x=Math.min(i+k,n);
				int min_x=Math.max(i-k,1);
				int max_y=Math.min(j+k,m);
				int min_y=Math.max(j-k,1);

				answer[i][j]=sum[max_x][max_y]-sum[min_x-1][max_y]-sum[max_x][min_y-1]+sum[min_x-1][min_y-1];
			}
		}
		
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int matrix[][]=new int[4][4];
		
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=3;j++) {
				matrix[i][j]=sc.nextInt();
			}
		}
		
		int answer[][]=solve(matrix, 2);
		
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=3;j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
