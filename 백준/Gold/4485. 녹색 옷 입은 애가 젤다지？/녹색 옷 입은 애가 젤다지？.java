import java.util.*;
import java.io.*;

public class Main{
    static int[][] map;
    static int n;
    
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    
    public static void main(String args[]) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        String input;
        int idx=1;

        while(!(input=br.readLine()).equals("0")){
            n = Integer.parseInt(input);
            map = new int[n][n];
            
            for(int i=0;i<n;i++){
                st= new StringTokenizer(br.readLine());
                
                for(int j=0;j<n;j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(idx++).append(": ").append(dijkstra()).append("\n");
        }
        
        System.out.println(sb);
    }

    private static int dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[2]-a2[2]);
        pq.add( new int[]{0, 0, map[0][0]});
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i], 10*125*125);
        dp[0][0] =map[0][0];

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(cur[0]==n-1 && cur[1]==n-1){
                return cur[2];
            }

            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                if(nx < 0 || nx>=n) continue;
                int ny = cur[1]+dy[i];
                if(ny < 0 || ny>= n) continue;

                if(dp[nx][ny] <=  cur[2] + map[nx][ny]) continue;
                dp[nx][ny]= cur[2] + map[nx][ny];

                pq.add(new int[]{nx, ny, dp[nx][ny]});
            }
        }

        return dp[n-1][n-1];
    }
}