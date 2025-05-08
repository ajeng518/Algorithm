import java.util.*;
import java.io.*;

public class Main {
    static int[] dx={0, 1, 0, -1};
    static int[] dy={1, 0, -1, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] visited=new boolean[n][m];
        int all=n*m-1;
        int[] cur={0, 0};
        visited[0][0]=true;
        
        int way=0;
        int ans=0;

        while(all>0){
            int i = 4;
            while(i-- > 0){
                int nx = cur[0]+dx[way%4];
                if(nx<0 || nx>=n){
                    way++;
                    ans++;
                    continue;
                }

                int ny = cur[1]+dy[way%4];
                if(ny<0 || ny>=m){
                    way++;
                    ans++;
                    continue;
                } 
                if(visited[nx][ny]) {
                    way++;
                    ans++;
                    continue;
                }

                visited[nx][ny]=true;
                cur=new int[]{nx, ny};
                all--;
                break;
            }
        }

        System.out.println(ans);
    }
}