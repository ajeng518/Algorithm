import java.util.*;
import java.io.*;

class Solution {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    
    public int solution(String dirs) {
        int answer = 0;
        
        char[] way=dirs.toCharArray();
        int size=way.length;
        Set<String> visited=new HashSet<>();
        int[][] map=new int[11][11];
        int x=5;
        int y=5;
        int cnt=0;
        
        for(int i=0; i<size; i++){
            int xyIdx=-1;
            
            if(way[i]=='U'){
                xyIdx=0;
            }else if(way[i]=='R'){
                xyIdx=1;
            }else if(way[i]=='D'){
                xyIdx=2;
            }else{//'L'
                xyIdx=3;
            }
            
            int nx=x+dx[xyIdx];
            if(nx<0 || nx> 10) continue;
            int ny=y+dy[xyIdx];
            if(ny<0 || ny> 10) continue;
            
            StringBuilder sb=new StringBuilder();
            sb.append(x).append(y).append(nx).append(ny);
            StringBuilder sbb=new StringBuilder();
            sbb.append(nx).append(ny).append(x).append(y);
            if(!visited.contains(sb.toString())){ 
                visited.add(sb.toString());
                visited.add(sbb.toString());
                cnt++;
            }
            x=nx;
            y=ny;
            
        }
        return cnt;
    }
}
