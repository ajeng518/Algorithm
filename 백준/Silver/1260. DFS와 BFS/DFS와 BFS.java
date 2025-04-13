import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static StringBuilder sb=new StringBuilder();
    static int[][] list;
    static int n, m;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        n =Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        int start=Integer.parseInt(st.nextToken());

        list=new int[n+1][n+1];

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());

            list[a][b]=1;
            list[b][a]=1;
        }

        visited=new boolean[n+1];
        dfs(start);
        sb.append("\n");

        visited=new boolean[n+1];
        bfs(start);

        System.out.println(sb);

        
    }

    private static void dfs(int start){
        visited[start]=true;
        sb.append(start).append(" ");

        for(int i=1; i<=n; i++){
            if(list[start][i] != 1) continue;
            if(visited[i]) continue;
            
            dfs(i);
        }
    }

    private static void bfs(int start){
        Deque<Integer> q=new ArrayDeque<>();
        q.add(start);
        visited[start]=true;

        while(!q.isEmpty()){
                int cur = q.poll();
                sb.append(cur).append(" ");
    
                for(int i=1;i<=n;i++){
                    if(list[cur][i] != 1) continue;
                    if(visited[i]) continue;
                    q.add(i);
                    visited[i]=true;
                }
        }
    }
}