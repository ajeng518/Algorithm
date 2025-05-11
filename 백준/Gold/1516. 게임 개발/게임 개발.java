import java.util.*;
import java.io.*;

public class Main {
    static class Building implements Comparable<Building>{
        int idx;
        int time;

        Building(int idx, int time){
            this.idx=idx;
            this.time=time;
        }

        public int compareTo(Building o){
            return this.time - o.time;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Building[] building = new Building[n+1];
        int[] parent=new int[n+1];
        
        List<Integer>[] list=new List[n+1];
        for(int i=1; i<=n; i++){
            list[i]=new ArrayList<>();
        }
        
        for(int i = 1; i <= n; i++){
            st=new StringTokenizer(br.readLine());

            building[i]=new Building(i, Integer.parseInt(st.nextToken()));

            while(true){
                int cur = Integer.parseInt(st.nextToken());
                
                if(cur == -1) break;
    
                list[cur].add(i);
                parent[i]++;
            }
        }

        topoloSort(n, building, parent, list);
        
        for(int i=1;i<=n;i++)
            sb.append(building[i].time).append("\n");

        System.out.println(sb);
    }

    private static void topoloSort(int n, Building[] building, int[] parent, List<Integer>[] list){
        PriorityQueue<Building> pq = new PriorityQueue<>();
        
        for(int i=1; i<=n; i++){
            if(parent[i] != 0) continue;

            pq.add(building[i]);
        }

        while(!pq.isEmpty()){
            Building cur = pq.poll();

            for(int next: list[cur.idx]){
                parent[next]--;

                if(parent[next] != 0) continue;

                building[next].time += building[cur.idx].time;
                pq.add(building[next]);
            }
        }
    }
}