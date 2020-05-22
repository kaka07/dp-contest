import java.util.*;
import java.lang.*;
import java.io.*;
class deque{
	static long[][][]dp=new long[3001][3001][2];
	static long solve(int i,int j,int[]arr,int turn){
		if(i>j)
			return 0;
		if(dp[i][j][turn]!=0)
			return dp[i][j][turn];
		if(turn==1)
			return dp[i][j][turn]=Math.max(arr[i]+solve(i+1,j,arr,0),arr[j]+solve(i,j-1,arr,0));
		else
			return dp[i][j][turn]=Math.min(solve(i+1,j,arr,1),solve(i,j-1,arr,1));
	}
	public static void main(String[] args)throws IOException{
		//Scanner in=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int []arr=new int[n+1];
		long sum=0;
		String s=br.readLine();
		String[]s1=s.split(" ");
		long y=0;
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(s1[i]);
			sum+=arr[i];
		}
		long x=solve(0,n-1,arr,1);
		// y=sum-x;
		System.out.println(x);
	}
}