import java.util.*;
import java.lang.*;
class frog2{
	static int frogJump(int n,int[]dp,int k,int[]arr){
		dp[1]=0;
		for(int i=2;i<=n;i++){
			dp[i]=Integer.MAX_VALUE;
			for(int j=i;j>=1&&(i-j)<=k;j--){
				dp[i]=Math.min(dp[i],Math.abs(arr[i]-arr[j])+dp[j]);
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int[]arr=new int[n+1];
		int[]dp=new int[n+1];
		for(int i=1;i<=n;i++){
			arr[i]=in.nextInt();
		}
		System.out.println(frogJump(n,dp,k,arr));
	}
}