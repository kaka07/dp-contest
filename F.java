import java.util.*;
import java.io.*;
import java.lang.*;
class lcs{
	static StringBuffer getString(char[]c,char[]d,int i,int j,int len,int[][]dp){
		StringBuffer l=new StringBuffer();
		while(len>0){
			if(c[i]==d[j]){
				l.append(c[i]);
				i++;
				j++;
				len--;
			}
			else{
				if(dp[i+1][j]>dp[i][j+1]){
					i++;
				}
				else
					j++;
			}
		}
		return l;
	}
	static int getLength(char[] c,char[] d,int i,int j,int[][]dp){
		if(i>=c.length||j>=d.length){
			return 0;
		}
		if(dp[i][j]!=0){
			return dp[i][j];
		}
		if(c[i]==d[j]){
			return dp[i][j]=(1+getLength(c,d,i+1,j+1,dp));
		}
		else{
			return dp[i][j]=Math.max(getLength(c,d,i+1,j,dp),getLength(c,d,i,j+1,dp));
		}
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s=in.nextLine();
		char[]c=s.toCharArray();
		String t=in.nextLine();
		char[]d=t.toCharArray();
		int[][]dp=new int[3001][3001];
		int len=getLength(c,d,0,0,dp);
		System.out.println(getString(c,d,0,0,len,dp));
	}
}