import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited=new boolean[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            
            bfs(i, n, computers);
            answer++;
        }
        
        
        return answer;
    }
    
    private static void bfs(int start, int n, int[][] computers){
        
        Deque<Integer> q=new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int j=0;j<n;j++){
                if(visited[j]) continue;
                if(computers[cur][j]==0) continue;
                
                q.add(j);
                visited[j]=true;
            }
        }
        
        return;
    }
}