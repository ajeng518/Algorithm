import java.util.*;
import java.io.*;

public class Main{
    static char[][] map;
    static int n, m;
    static int[] dx = {-1, 0 ,1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String args[]) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] coins=new int[2][2];
        int idx=0;
        
        map=new char[n][m];
        for(int i=0;i<n;i++){
            map[i]=br.readLine().toCharArray();
            
            for(int j=0; j<m;j++){
                if(map[i][j] !='o') continue;

                coins[idx++] = new int[]{i,j};
            }
        }
        
        int ans = bfs(coins);
        System.out.println(ans);
    }

    private static int bfs(int[][] coins){
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{coins[0][0], coins[0][1], coins[1][0], coins[1][1]});

        int cnt =0;

        while(!q.isEmpty()){
            int size = q.size();
            if(cnt > 10) break;

            while(size -- > 0){
                int[] cur = q.poll();

                if(chkValue(cur)) return cnt;

                for(int i=0;i<4; i++){
                    int nx1 = cur[0]+dx[i];
                    int ny1 = cur[1]+dy[i];
                    int nx2 = cur[2]+dx[i];
                    int ny2 = cur[3]+dy[i];

                    if(nx1 >=0 && nx1 < n && ny1 >=0 && ny1 < m && nx2 >=0 && nx2 < n && ny2 >=0 && ny2 < m){//첫, 둘 모두 맵 안에 있다.
                        if(map[nx1][ny1] == '#'){
                            nx1=cur[0];
                            ny1=cur[1];
                        }
                        if(map[nx2][ny2] == '#'){
                            nx2=cur[2];
                            ny2=cur[3];
                        }
                    }else if(nx1 >=0 && nx1 < n && ny1 >=0 && ny1 < m){//첫번째 동전이 맵 안에 있다.
                        if(map[nx1][ny1]=='#'){
                            nx1=cur[0];
                            ny1=cur[1];
                        }
                        
                        nx2 = nx2*100;
                        ny2 = ny2*100;
                    }else if(nx2 >=0 && nx2 < n && ny2 >=0 && ny2 < m){//두번째 동전이 맵 안에 있다.
                        if(map[nx2][ny2]=='#'){
                            nx2=cur[2];
                            ny2=cur[3];
                        }
                        nx1 = nx1*100;
                        ny1 = ny1*100;
                    }else continue;

                    q.offer(new int[]{nx1, ny1, nx2, ny2});
                }    
            }
            
            cnt++;
        }

        return -1;
    }

    private static boolean chkValue(int[] cur){
        if(cur[0] >= n || cur[0] < 0 || cur[1] >=m || cur[1] < 0){
            if(cur[2] >= 0 || cur[2] < n || cur[3] >=0 || cur[3] < m){
                return true;
            }
        }else if(cur[2] >= n || cur[2] < 0 || cur[3] >=m || cur[3] < 0){
            if(cur[0] >= 0 || cur[0] < n || cur[1] >=0 || cur[1] < m){
                return true;
            }
        }
        return false;
    }
}
