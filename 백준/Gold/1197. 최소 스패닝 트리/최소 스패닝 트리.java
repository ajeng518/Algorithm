import java.util.*;
import java.io.*;

public class Main{
    static int v, e;
    static List<Node>[] list;

    static class Node implements Comparable<Node> {
		int next;
		int cost;

		public Node() {
			super();
		}

		public Node(int next, int cost) {
			this.next = next;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
            return this.cost - o.cost;
		}
	}
    
    public static void main(String args[]) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st=new StringTokenizer(br.readLine());

        int answer=0;

        v= Integer.parseInt(st.nextToken());//정점
        e= Integer.parseInt(st.nextToken());//간선
        
        list = new List[v+1];
        for(int i=0;i<=v;i++) list[i]=new ArrayList<>();

        for(int i=1;i<=e;i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            list[a].add(new Node(b, cost));
            list[b].add(new Node(a, cost));
        }
        
        System.out.println(prim());
    }
    
    private static int prim(){
        PriorityQueue<Node>pq =new PriorityQueue<>();
        pq.add(new Node(1, 0));
        boolean[] visited = new boolean[v+1];
        int ans =0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.next]) continue;
            ans+=cur.cost;
            visited[cur.next]=true;

            for(Node next: list[cur.next]){
                if(visited[next.next]) continue;
                pq.offer(next);
            }
        }

        return ans;
    }
}
