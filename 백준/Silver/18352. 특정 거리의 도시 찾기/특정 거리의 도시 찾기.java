import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static List<Integer> ans;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        List<Integer>[] road= new List[n+1];
        for(int i =0;i<=n ;i++) road[i]=new ArrayList<>();

        for(int i =0;i<m;i++){
            st =new StringTokenizer(br.readLine());

            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            road[a].add(b);
        }

        ans=new ArrayList<>();
        dijkstra(start, road);
        Collections.sort(ans);
        
        for(int answer : ans){
            sb.append(answer).append("\n");
        }

        if(ans.size()==0) sb.append(-1);

        System.out.println(sb);
    }

    private static void dijkstra(int start, List<Integer>[] road){
        int[] dp=new int[n+1];
        boolean[] visited=new boolean[n+1];
        Arrays.fill(dp, 3000000);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a1, a2)-> a1[1]-a2[1]);
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            
            if(visited[cur[0]]) continue;
            visited[cur[0]]=true;
            
            if(cur[0]!=start && cur[1]==k) ans.add(cur[0]);

            for(int next: road[cur[0]]){
                if(visited[next]) continue;
                if(dp[next]<=cur[1]+ 1) continue;
                if(cur[1]+1>k) continue;
                
                dp[next]=cur[1]+1;
                pq.add(new int[]{next, dp[next]});
            }
        }
    }
}