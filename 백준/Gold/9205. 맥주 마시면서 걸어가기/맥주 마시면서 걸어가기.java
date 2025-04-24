import java.util.*;
import java.io.*;

public class Main {
    static int sx, sy, dx, dy;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n =Integer.parseInt(br.readLine());//편의점 수

            List<int[]> store=new ArrayList<>();
            
            for(int i = 0;i<n+2; i++){
                st=new StringTokenizer(br.readLine());
                int x =Integer.parseInt(st.nextToken());
                int y =Integer.parseInt(st.nextToken());

                if(i==0){
                    sx=x;
                    sy=y;
                }else if(i==n+1){
                    dx=x;
                    dy=y;
                }else store.add(new int[]{x, y});
            }

            String ans =bfs(n, store)?"happy":"sad";
            sb.append(ans).append("\n");
            
        }

        System.out.println(sb);
    }

    private static boolean bfs(int n, List<int[]> store){
        Deque<int[]> q=new ArrayDeque<>();
        boolean[] visited=new boolean[n];

        q.add(new int[]{sx, sy});

        while(!q.isEmpty()){
            int[] cur=q.poll();

            if(Math.abs(cur[0]-dx) + Math.abs(cur[1]-dy) <= 1000) return true;

            for(int i=0;i<n;i++){
                if(visited[i]) continue;
                
                int[] next=store.get(i);
                int dist = Math.abs(cur[0]-next[0]) + Math.abs(cur[1]-next[1]);

                if(dist > 1000) continue;

                q.add(new int[]{next[0], next[1]});
                visited[i]=true;
            }
        }
        return false;
    }
}