import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static boolean[] visited;
    static List<Integer>[] tree;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n =Integer.parseInt(br.readLine());
        
        dp=new int[n+1][2];
        visited=new boolean[n+1];
        tree=new List[n+1];
        
        for(int i=0;i<=n;i++)tree[i]=new ArrayList<>();
        
        while(--n > 0){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int num){
        visited[num]=true;

        dp[num][1]=1;
        dp[num][0]=0;

        for(int next : tree[num]){
            if(visited[next]) continue;

            dfs(next);
            
            dp[num][0]+=dp[next][1];
            dp[num][1]+=Math.min(dp[next][1], dp[next][0]);
        }
    }
}