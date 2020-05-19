import java.util.*;
import java.lang.*;
class frog{
	static int frogJump(int n,int[]dp,int[]arr){
		dp[1]=0;
		int inf=1000000;
		for(int i=2;i<=n;i++){
			int op1=Math.abs(arr[i]-arr[i-1])+dp[i-1];
			int op2=(i==2)?inf:Math.abs(arr[i]-arr[i-2])+dp[i-2];
			dp[i]=Math.min(op1,op2);
		}
		return dp[n];
	}
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		int[]arr=new int[n+1];
		int[]dp=new int[n+1];
		for(int i=1;i<=n;i++){
			arr[i]=in.nextInt();
		}
		System.out.println(frogJump(n,dp,arr));
	}
}