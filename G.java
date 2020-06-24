import java.util.*;
import java.lang.*;
import java.math.*;
class G{
	static int solve(int src,ArrayList<ArrayList<Integer>>graph,int[]dp){
		if(dp[src]!=0)
			return dp[src];
		boolean leaf=true;
		int bestChild=0;
		for(int child:graph.get(src)){
			leaf=false;
			bestChild=Math.max(bestChild,solve(child,graph,dp));
		}
		return dp[src]=leaf?0:1+bestChild;
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		ArrayList<ArrayList<Integer>>graph=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=n;i++)
			graph.add(new ArrayList<Integer>());
		for(int i=0;i<m;i++){
			int x=in.nextInt();
			int y=in.nextInt();
			graph.get(x).add(y);
		}
		int[]dp=new int[100001];
		int ans=0;
		for(int i=1;i<=n;i++){
			ans=Math.max(ans,solve(i,graph,dp));
		}
		System.out.println(ans);
	}
}