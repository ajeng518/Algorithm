import java.util.*;

class Solution {
    static List<Integer>[] nodeList;
    static boolean[] visited;
    static int[] dp;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        nodeList=new List[n+1];
        for(int i=1;i<=n;i++){
            nodeList[i]=new ArrayList<>();
        }
        
        for(int i=0;i<edge.length;i++){
            nodeList[edge[i][0]].add(edge[i][1]);
            nodeList[edge[i][1]].add(edge[i][0]);
        }
        visited=new boolean[n+1];
        dp=new int[n+1];
        dijkstra(n);
        
        int max=-1;
        for(int i=2;i<=n;i++){
            if(max>dp[i]) continue;
            if(max==dp[i]) answer++;
            if(max<dp[i]){
                max=dp[i];
                answer=1;
            }
        }
        
        return answer;
    }
    
    private static void dijkstra(int n){
        Deque<Integer> q=new ArrayDeque<>();
        q.add(1);
        int cnt=0;
        Arrays.fill(dp, 20001);
        dp[1]=0;
        visited[1]=true;
        
        while(!q.isEmpty()){
            int size=q.size();
            
            while(size-- >0){
                int cur=q.poll();
                
                for(int next: nodeList[cur]){
                    if(visited[next]) continue;
                    if(dp[next]<=dp[cur]+1) continue;
                    dp[next]=dp[cur]+1;
                    
                    q.add(next);
                    visited[next]=true;
                }
            }
        }
        
        return ;
    }
}