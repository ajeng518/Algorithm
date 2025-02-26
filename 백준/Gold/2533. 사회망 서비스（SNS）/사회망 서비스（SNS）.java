import java.util.*;
import java.io.*;

public class Main {
  static int n;
  static List<Integer>[] friends;
  static int[][] dp;
  static boolean[] visited;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n=Integer.parseInt(br.readLine());
    friends=new List[n+1];
    for(int i=1;i<=n;i++) friends[i]=new ArrayList<>();

    for(int i=0;i<n-1;i++){
      st=new StringTokenizer(br.readLine());
      int nodeA=Integer.parseInt(st.nextToken());
      int nodeB=Integer.parseInt(st.nextToken());
      
      friends[nodeA].add(nodeB);
      friends[nodeB].add(nodeA);
    }

    dp=new int[n+1][2];
    visited=new boolean[n+1];

    dfs(1);
    System.out.println(Math.min(dp[1][0], dp[1][1]));
    

  }

  private static void dfs(int num){
    visited[num]=true;
    dp[num][0]=0;
    dp[num][1]=1;

    for(int child: friends[num]){
      if(visited[child]) continue;
      dfs(child);
      dp[num][0]+=dp[child][1];
      dp[num][1]+=Math.min(dp[child][1], dp[child][0]);
    }
  }
}