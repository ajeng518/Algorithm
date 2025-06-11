import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] link = new List[n+1];
        for(int i=1;i<=n;i++) link[i]=new ArrayList<>();

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            link[b].add(a);
        }
        List<Integer> maxStart=new ArrayList<>();
        int max = -1;
        
        for(int i=1;i<=n;i++){
            int cur = bfs(n, m, i, link);
            
            if(max < cur){
                max =cur;
                maxStart=new ArrayList<>();
                maxStart.add(i);
            }else if(max==cur) maxStart.add(i);
        }
        
        for(int num : maxStart){
            sb.append(num).append(" ");
        }

        System.out.println(sb);
        
    }

    private static int bfs(int n, int m, int start, List<Integer>[] link){
        Deque<Integer> q=new ArrayDeque<>();

        q.add(start);
        boolean[] visited=new boolean[n+1];
        visited[start]=true;
        int cnt=0;

        while(!q.isEmpty()){
            int cur = q.poll();
            cnt++;
            
            for(int next: link[cur]){
                if(visited[next]) continue;
                q.add(next);
                visited[next]=true;
            }
            
        }

        return cnt;
    }
}