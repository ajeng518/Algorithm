import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());

    int a=Integer.parseInt(st.nextToken());
    int b=Integer.parseInt(st.nextToken());

    long ans = bfs(a, b);
    System.out.println(ans>-1?ans+1: ans);
    
  }
  private static long bfs(int a, int b){
    Set<Long> visited = new HashSet<>();
    Deque<Long> q=new ArrayDeque<>();
    q.add((long)a);
    visited.add((long)a);
    int cnt=0;

    while(!q.isEmpty()){
      int size=q.size();

      while(size-->0){
        long cur =q.poll();

        if(cur == b) return cnt;

        if(!visited.contains(cur*2) && cur*2 <=b){
          q.add(cur*2);
          visited.add(cur*2);
        }

        if(!visited.contains(cur*10+1) && cur*10+1 <=b){
          q.add(cur*10+1);
          visited.add(cur*10+1);
        }
      }

      cnt++;
    }

    return -1;
    
  }
}