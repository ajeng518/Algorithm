import java.io.*;
import java.util.*;

class Solution {
    static int n, m, cnt;
    static char[][] map;
    static int[] alphabet;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        n=storage.length;
        m=storage[0].length();
        cnt=n*m;
        
        map=new char[n][m];
        for(int i=0;i<n;i++){
            String[] line = storage[i].split("");
            
            for(int j=0; j<m; j++){
                map[i][j] = line[j].charAt(0);
            }
        }
        
        alphabet=new int[26];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                alphabet[map[i][j] -'A']++;
            }
        }
        
        for(int now=0; now<requests.length; now++){
            boolean[][] box = new boolean[n][m];
            String cur = requests[now];
            char contain = cur.charAt(0);
            
            if(alphabet[contain-'A']==0) continue;
            
            if(cur.length() > 1){//크레인
                for(int i=0; i<n; i++){
                    for(int j=0; j<m; j++){
                        if(map[i][j]!= contain) continue;
                        box[i][j]=true;
                    }
                }
            }else{//지게차
                for(int i=0; i<n; i++){
                    for(int j=0; j<m; j++){
                        if(map[i][j]!= contain) continue;
                        if(fork(i, j, contain)){
                            box[i][j]=true;
                        } 
                    }
                }
            }
            
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(!box[i][j]) continue;
                    
                    alphabet[map[i][j]-'A']--;
                    map[i][j]=0;
                    cnt--;
                }
            }
        }
        
        return cnt;
    }
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    private static boolean fork(int x, int y, char contain){
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n+1][m+1];
        
        q.offer(new int[]{x, y});
        visited[x][y]=true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                if(nx <0 || nx >=n) return true;
                
                int ny = cur[1]+dy[i];
                if(ny < 0 || ny>= m) return true;
                
                if(!visited[nx][ny] && map[nx][ny]==0){
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny]=true;
                }
            }
        }
        
        return false;
    }
}