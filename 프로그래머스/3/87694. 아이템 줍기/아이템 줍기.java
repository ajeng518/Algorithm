import java.util.*;
import java.io.*;

class Solution {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static int[][] map;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        map=new int[105][105];
        
        for(int i=0;i<rectangle.length; i++){
            int x1=rectangle[i][0]*2;//left
            int y1=rectangle[i][1]*2;//top
            int x2=rectangle[i][2]*2;//right
            int y2=rectangle[i][3]*2;//bottom
            
            for(int x=x1; x<=x2; x++){
                for(int y=y1; y<=y2; y++){
                    if(map[x][y]==2) continue;
                    map[x][y]=2;
                    
                    if(x==x1 ||x==x2 || y==y1 || y==y2)
                        map[x][y]=1;
                }
            }
        }
        
        answer=bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        
        return answer;
    }
    
    private static int bfs(int sx, int sy, int ex, int ey){
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited=new boolean[105][105];
        int cnt=0;
        
        q.add(new int[]{sx, sy});
        visited[sx][sy]=true;
        
        while(!q.isEmpty()){
            int size=q.size();
            
            while(size-- > 0){
                int[] cur= q.poll();
                
                if(cur[0]==ex && cur[1]==ey) return cnt/2;
                
                for(int i=0; i<4; i++){
                    int nx = cur[0]+dx[i];
                    int ny = cur[1]+dy[i];
                    
                    if(map[nx][ny] != 1) continue;
                    if(visited[nx][ny]) continue;
                    
                    
                    q.add(new int[]{nx, ny});
                    visited[nx][ny]=true;
                }
            }
            
            cnt++;
        }
        
        return 0;
    }
}