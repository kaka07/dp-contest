import java.util.*;
import java.lang.*;
class knapsack{
	static class item{
		int wt;
		int val;
		item(int wt,int val){
			this.wt=wt;
			this.val=val;
		}
	}
	static int knap(item[]arr,int n,int we){
		int [][]dp=new int[n+1][we+1];
		for(int w=0;w<we;w++){
			dp[1][w]=0;
		}
		dp[1][arr[1].wt]=arr[1].val;
		for(int i=2;i<=n;i++){
			for(int w=0;w<=we;w++){
				dp[i][w]=dp[i-1][w];
				if(arr[i].wt>w)
					continue;
				dp[i][w]=Math.max(dp[i][w],arr[i].val+dp[i-1][w-arr[i].wt]);
			}
		}
		return dp[n][we];
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int we=in.nextInt();
		item[]arr=new item[n+1];
		for(int i=1;i<=n;i++){
			arr[i].wt=in.nextInt();
			arr[i].val=in.nextInt();
		}
		System.out.println(knap(arr,n,we));

	}
}