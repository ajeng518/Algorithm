import java.util.*;
import java.io.*;

public class Main {
  static class Bus implements Comparable<Bus>{
    int start;
    int end;
    int cost;

    Bus(int start, int end, int cost){
      this.start=start;
      this.end=end;
      this.cost=cost;
    }

    @Override
    public int compareTo(Bus o){
      return this.cost-o.cost;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb=new StringBuilder();

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    List<Bus> busList = new ArrayList<>();
    for(int i=0;i<m;i++){
      st=new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      busList.add(new Bus(s, e, c));
    }

    long[] dp=new long[n+1];
    Arrays.fill(dp, Long.MAX_VALUE);

    if(!bellmanford(n, m, busList, dp)){
      sb.append(-1);
    }else{
      for(int i=2;i<=n;i++){
        if(dp[i]==Long.MAX_VALUE) sb.append(-1).append("\n");
        else sb.append(dp[i]).append("\n");
      }
    }

    System.out.println(sb);
    
  }

  private static boolean bellmanford(int n, int m, List<Bus> list, long[] dp){
    dp[1]=0L;

    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        Bus cur = list.get(j);

        if(dp[cur.start]==Long.MAX_VALUE) continue;
        if(dp[cur.end] <= (dp[cur.start]+cur.cost)) continue;
        
        dp[cur.end]= dp[cur.start]+cur.cost;

        if(i+1 ==n) return false;
      }
    }

    return true;
  }
}