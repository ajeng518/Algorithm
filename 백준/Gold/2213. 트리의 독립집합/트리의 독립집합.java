import java.util.*;
import java.io.*;

public class Main {    
    static List<Integer>[] tree;
    static int[] v;
    static int[][] dp;
    static boolean[] visited;
    static List<Integer> ans;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int n =Integer.parseInt(br.readLine());
        v=new int[n+1];

        st=new StringTokenizer(br.readLine());
        for(int i=1; i<=n;i++){
            v[i]=Integer.parseInt(st.nextToken());
        }

        tree=new List[n+1];
        for(int i=0;i<=n;i++){
            tree[i]=new ArrayList<>();
        }

        for(int i=1; i<n;i++){
            st=new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        dp=new int[n+1][2];
        visited=new boolean[n+1];

        dfs(1);
        
        ans=new ArrayList<>();
        visited=new boolean[n+1];
        
        if(dp[1][1]>dp[1][0]){
            sb.append(dp[1][1]).append("\n");
            trace(1, 1);
        }else{
            sb.append(dp[1][0]).append("\n");
            trace(1, 0);
        }

        Collections.sort(ans);
        for(int num : ans) sb.append(num).append(" ");

        System.out.println(sb);
        
    }

    private static void dfs(int num){
        visited[num]=true;

        dp[num][0]=0;
        dp[num][1]=v[num];

        for(int next: tree[num]){
            if(visited[next]) continue;

            dfs(next);
            
            dp[num][0]+=Math.max(dp[next][0], dp[next][1]);
            dp[num][1]+=dp[next][0];
        }
    }

    private static void trace(int num, int chk){
        visited[num]=true;

        if(chk==1){
            ans.add(num);
            
            for(int next: tree[num]){
                if(visited[next]) continue;

                trace(next, 0);
            }
        }else{
            for(int next: tree[num]){
                if(visited[next]) continue;

                if(dp[next][1] > dp[next][0]){
                    trace(next, 1);
                }else{ 
                    trace(next, 0);
                }
            }
        }
    }
}