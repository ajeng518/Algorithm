import java.util.*;
import java.io.*;

public class Main {
    static class Car implements Comparable<Car>{
        int idx;
        int pos;
        int fuel;

        Car(int idx, int pos, int fuel){
            this.idx=idx;
            this.pos=pos;
            this.fuel=fuel;
        }

        public int compareTo(Car o){
            return this.pos-o.pos;
        }
    }

    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        
        int[] firstPos=new int[n];
        int[] firstFuel=new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            firstPos[i]=Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            firstFuel[i]=Integer.parseInt(st.nextToken());
        }

        Car[] carArray=new Car[n];
        for(int i=0;i<n;i++){
            carArray[i]=new Car(i+1, firstPos[i], firstFuel[i]);
        }
        
        visited=new boolean[n+1];
        bfs(n, s, carArray);

        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++){
            if(!visited[i]) continue;

            sb.append(i).append(" ");
        }

        System.out.println(sb);

    }

    private static void bfs(int n, int s, Car[] carArray){
        Deque<Car> q = new ArrayDeque<>();
        q.add(carArray[s-1]);
        Arrays.sort(carArray);

        visited[s]=true;

        while(!q.isEmpty()){
            Car cur = q.poll();

            for(int i=cur.idx-1; i>=0;i--){
                if(carArray[i].pos < cur.pos - cur.fuel)
                    break;
                if(visited[carArray[i].idx]) continue;

                q.add(carArray[i]);
                visited[carArray[i].idx]=true;
            }

            for(int i=cur.idx; i<n;i++){
                if(carArray[i].pos > cur.pos+cur.fuel)
                    break;
                if(visited[carArray[i].idx]) continue;

                q.add(carArray[i]);
                visited[carArray[i].idx]=true;
            }
        }
    }
}