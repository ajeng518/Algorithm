import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n=Integer.parseInt(st.nextToken());
    int t=Integer.parseInt(st.nextToken());
    
    long[] happy=new long[n+1];
    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=n;i++){
      happy[i]=Integer.parseInt(st.nextToken());
    }

    long[] road=new long[n+1];
    long[] sum=new long[n+1];
    for(int i=1;i<n;i++){
      road[i]=happy[i]+happy[i+1];
      sum[i]=sum[i-1]+road[i];
    }

    long ans=0L;
    t/=2;
    for(int i=1;i<n;i++){
      if(i>t) continue;
      ans=Math.max(ans, sum[i-1]+road[i]*(t-(i-1)));
    }
    
    System.out.println(ans);
  }
}