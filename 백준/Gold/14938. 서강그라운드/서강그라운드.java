import java.util.*;
import java.io.*;

public class Main {
  static class Node implements Comparable<Node>{
    int node;
    int cost;

    Node(int node, int cost){
      this.node=node;
      this.cost=cost;
    }

    public int compareTo(Node o){
      return this.cost-o.cost;
    }
  }
  
  static int n, m, r;
  static int[] item;
  static List<Node>[] list;  
  static int[][] minLenList;

  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());

    n=Integer.parseInt(st.nextToken());//지역 수
    m=Integer.parseInt(st.nextToken());//수색범위
    r=Integer.parseInt(st.nextToken());//길의 개수

    item=new int[n+1];
    st=new StringTokenizer(br.readLine());
    for(int i=1; i<= n; i++){
      item[i]=Integer.parseInt(st.nextToken());
    }

    list=new List[n+1];
    for(int i=1;i<=n;i++) list[i]=new ArrayList<>();

    for(int i =0; i<r; i++){
      st=new StringTokenizer(br.readLine());
      int start=Integer.parseInt(st.nextToken());
      int end=Integer.parseInt(st.nextToken());
      int len=Integer.parseInt(st.nextToken());

      list[start].add(new Node(end, len));
      list[end].add(new Node(start, len));
    }

    minLenList=new int[n+1][n+1];
    for(int i=1;i<=n-1;i++)
      dijkstra(i);

    minLenList[n][n]=Integer.MAX_VALUE;

    int ans=0;
    for(int i=1; i<=n; i++){
      ans=Math.max(findMaxItems(i), ans);
    }
    System.out.println(ans);
  }

  private static void dijkstra(int start){
    boolean[] visited = new boolean[n+1];
    PriorityQueue<Node> pq=new PriorityQueue<>();
    int[] dp = new int[n+1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    
    dp[start]=0;
    pq.add(new Node(start, 0));

    while(!pq.isEmpty()){
      Node cur=pq.poll();

      if(visited[cur.node]) continue;
      visited[cur.node]=true;

      for(Node next: list[cur.node]){
        if(visited[next.node]) continue;
        if(dp[next.node] <= dp[cur.node] + next.cost) continue;

        dp[next.node] = dp[cur.node] + next.cost;
        pq.add(new Node(next.node, dp[next.node]));
        
      }
    }
    
    minLenList[start]=dp.clone();
    minLenList[n][start]=dp[n];
  }

  private static int findMaxItems(int start){
    int sum =item[start];
    
    for(int i=1;i<=n;i++){
      if(i==start) continue;
      if(minLenList[start][i] > m) continue;
      
      sum+=item[i];
    }

    return sum;
  }
}