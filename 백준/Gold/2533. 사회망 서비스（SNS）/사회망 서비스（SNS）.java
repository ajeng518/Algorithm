import java.util.*;
import java.io.*;

public class Main {
  static int n;
  static Node[] friends;
  static int[][] dp;
  static boolean[] visited;

  static class Node{
    int node;
    Node next;

    Node(int node, Node next){
      this.node=node;
      this.next=next;
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n=Integer.parseInt(br.readLine());
    friends=new Node[n+1];

    for(int i=0;i<n-1;i++){
      st=new StringTokenizer(br.readLine());
      int nodeA=Integer.parseInt(st.nextToken());
      int nodeB=Integer.parseInt(st.nextToken());
      
      friends[nodeA]=new Node(nodeB, friends[nodeA]);
      friends[nodeB]=new Node(nodeA, friends[nodeB]);
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

    for(Node child=friends[num]; child !=null; child=child.next){
      if(visited[child.node]) continue;
      dfs(child.node);
      dp[num][0]+=dp[child.node][1];
      dp[num][1]+=Math.min(dp[child.node][1], dp[child.node][0]);
    }
  }
}