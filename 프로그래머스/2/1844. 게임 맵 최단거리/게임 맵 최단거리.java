import java.util.*;

class Solution {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static int n, m;
    
    public int solution(int[][] maps) {
        int answer = 0;
        n =maps.length;
        m = maps[0].length;
        
        answer = bfs(maps);
        return answer;
    }
    
    public static int bfs(int[][] maps){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        
        boolean[][] visited = new boolean[n][m];
        visited[0][0]=true;
        
        int min =10000;
        int cnt=1;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size -- > 0){
                int[] cur = q.poll();
                
                if(cur[0]==n-1 && cur[1]==m-1){
                    return cnt;
                }
                
                for(int i=0;i<4;i++){
                    int nx = cur[0]+dx[i];
                    if(nx< 0 || nx>=n) continue;
                    
                    int ny = cur[1]+dy[i];
                    if(ny < 0 || ny>= m) continue;
                    
                    if(visited[nx][ny]) continue;
                    if(maps[nx][ny] == 0) continue;
                    
                    q.add(new int[]{nx, ny});
                    visited[nx][ny]=true;
                }
                
            }
            cnt++;
        }
        
        return -1;
    }
}