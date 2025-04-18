import java.util.*;
import java.io.*;

public class Main {
    static int[] dx={-1, 0, 1};
    static int[] dy={1, 1, 1};
    static boolean finished;
    static int r, c, cnt;
    static char[][] map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map=new char[r][c];
        
        for(int i =0;i<r;i++) map[i]=br.readLine().toCharArray();

        for(int i = 0; i< r; i++){
            finished=false;
            map[i][0]='@';
            dfs(i, 0);
        }

        System.out.println(cnt);
    }

    private static void dfs(int x, int y){
        if(y==c-1){
            finished=true;
            cnt++;
            return;
        }

        for(int i=0; i<3;i++){
            int nx = x + dx[i];
            if(nx<0 || nx >=r) continue;
            
            int ny = y + dy[i];
            if(ny >=c) continue;

            if(map[nx][ny] != '.') continue;
            if(finished) continue;

            map[nx][ny]='@';
            dfs(nx, ny);
        }
    }
}