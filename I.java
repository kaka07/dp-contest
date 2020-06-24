import java.util.*;
import java.lang.*;
import java.io.*;
public class Main{
	static double[][]dp=new double[3001][3001];
	static double solve(double[]arr,int i,int x){
		if(x==0)
			return 1;
		if(i==0)
			return 0;
		if(dp[i][x]!=0)
			return dp[i][x];
		return dp[i][x]=arr[i-1]*solve(arr,i-1,x-1)+(1-arr[i-1])*solve(arr,i-1,x);

	}
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String s=br.readLine();
		String[]s1=s.split(" ");
		double[]arr=new double[n];
		for(int i=0;i<n;i++){
			arr[i]=Double.parseDouble(s1[i]);
		}
		System.out.println(solve(arr,n,(n+1)/2));
	}

}
