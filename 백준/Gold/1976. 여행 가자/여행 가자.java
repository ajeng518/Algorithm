import java.util.*;
import java.io.*;

public class Main {
  static int[][] map;
  static int n, m;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n=Integer.parseInt(br.readLine());
    m=Integer.parseInt(br.readLine());
    
    map=new int[n+1][n+1];
    for(int i=1; i<=n; i++){
      st=new StringTokenizer(br.readLine());
      
      for(int j=1; j<=n; j++){
        map[i][j]=Integer.parseInt(st.nextToken());
      }
    }
    
    int[] plan=new int[m];
    st=new StringTokenizer(br.readLine());
    for(int i=0;i<m;i++) plan[i]=Integer.parseInt(st.nextToken());
    
    for(int i=0;i<m-1;i++){
      if(!bfs(plan[i], plan[i+1])){
        System.out.println("NO");
        System.exit(0);
      }
    }
    System.out.println("YES");
    
  }

  private static boolean bfs(int start, int end){
    Deque<Integer> q = new ArrayDeque<>();
    boolean[] chk=new boolean[n+1];
    q.add(start);
    chk[start]=true;

    while(!q.isEmpty()){
      int cur=q.poll();
      if(cur==end) return true;
      
      for(int i=1;i<=n;i++){
        if(map[cur][i]==0) continue;
        if(chk[i]) continue;
        
        chk[i]=true;
        q.add(i);
      }
    }

    return false;
  }
}