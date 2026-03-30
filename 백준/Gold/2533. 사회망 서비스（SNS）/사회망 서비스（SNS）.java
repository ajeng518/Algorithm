import java.util.*;
import java.io.*;

public class Main{
    static List<Integer>[] list;
    static int n;
    static boolean[] visited;
    static int[][] dp;
    
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        list=new List[n+1];
        for(int i=0;i<=n;i++) list[i]=new ArrayList<>();

        for(int i=1; i<n;i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        
        visited = new boolean[n+1];

        dp=new int[n+1][2];
        
        dfs(1);
        
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int cur){
        visited[cur]=true;

        dp[cur][1]=1;
        dp[cur][0]=0;
        
        for(int next: list[cur]){
            if(visited[next]) continue;

            dfs(next);
            
            dp[cur][0] += dp[next][1];
            dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}