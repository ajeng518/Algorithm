import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n=Integer.parseInt(br.readLine());
    int[] num=new int[n+1];
    st=new StringTokenizer(br.readLine());
    for(int i=1;i<=n;i++) num[i]=Integer.parseInt(st.nextToken());

    long[][] dp=new long[21][n+1];
    dp[num[1]][1]=1;

    for(int i=2; i<n;i++){
      for(int sum=0; sum<=20; sum++){
        if(sum-num[i]>=0)
          dp[sum][i]+=dp[sum-num[i]][i-1];
        
        if(sum+num[i]<=20)
          dp[sum][i]+=dp[sum+num[i]][i-1];
      }
    }

    System.out.println(dp[num[n]][n-1]);
  }
}