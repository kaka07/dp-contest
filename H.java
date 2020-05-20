import java.util.*;
import java.lang.*;
class grid{
	static int grids(char[][]arr,int n,int m){
		int[][]dp=new int[n+1][m+1];
		dp[n][m]=1;
		for(int i=n;i>=1;i--){
			for (int j=m;j>=1;j--) {
				if(i==n&&j==m)
					continue;
				if(arr[i][j]=='#'){
					dp[i][j]=0;
				}
				else
				dp[i][j]=(((i==n)?0:dp[i+1][j])+((j==m)?0:dp[i][j+1]))%1000000007;
			}
		}
		return dp[1][1];
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		//String s;
		char[][]arr=new char[n+1][m+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				arr[i][j]=in.next().charAt(0);
			}
		}
		//System.out.println(grids(arr,n,m));
	}
}