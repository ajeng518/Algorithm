import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int n, min;
    static int[][] food;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        food=new int[n][2];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            food[i][0]=Integer.parseInt(st.nextToken());
            food[i][1]=Integer.parseInt(st.nextToken());
        }

        visited=new boolean[n+1];
        min=Integer.MAX_VALUE;
        dfs(0, 0);

        System.out.println(min);
    }

    private static void dfs(int now, int cnt){
        if(now==n){
            if(cnt==0) return;
            
            int salt=0;//+
            int sour=1;//*
            
            for(int i=0;i<n;i++){
                if(!visited[i]) continue;
                
                salt+=food[i][1];
                sour*=food[i][0];
            }
            
            min = min > Math.abs(sour-salt) ? Math.abs(sour-salt) : min;

            return;
        }

        visited[now]=true;
        dfs(now+1, cnt+1);
        visited[now]=false;
        dfs(now+1, cnt);
    }
}