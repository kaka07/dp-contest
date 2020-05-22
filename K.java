import java.util.*;
import java.lang.*;
class stones{
	static String pile(int n,int[]arr,int[]dp,int k){
		for(int i=1;i<=k;i++){
			for(int move:arr){
				if(move>i)
					continue;
				if(dp[i-move]==0)
					dp[i]=1;
			}
		}
		return dp[k]==1?"First":"Second";
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int[]arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=in.nextInt();
		}
		int[]dp=new int[k+1];
		System.out.println(pile(n,arr,dp,k));

	}
}