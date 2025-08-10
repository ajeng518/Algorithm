import java.util.*;
import java.io.*;

public class Main{
    static int v, e;
    static int[] parent,rank;

    static class Node implements Comparable<Node> {
		int s;
		int e;
		int cost;

		public Node() {
			super();
		}

		public Node(int s, int e, int cost) {
			super();
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);// 오름차순
		}

	}
    
    public static void main(String args[]) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st=new StringTokenizer(br.readLine());

        int answer=0;

        v= Integer.parseInt(st.nextToken());
        e= Integer.parseInt(st.nextToken());

        parent = new int[v+1];
        rank =new int[v+1];
        
        for(int i=1;i<=v;i++){
            parent[i]=i;
            rank[i]=1;
        } 

        PriorityQueue<Node>pq=new PriorityQueue<>();
        
        for(int i=1;i<=e;i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            pq.add(new Node(a, b, cost));
        }
        
        int cnt=0;
        
		while(cnt!=v-1) {
			Node n=pq.poll();
            
			if(union(n.s, n.e)) {
				cnt++;
				answer+=n.cost;
			}
		}

         
        System.out.println(answer);
    }
    private static boolean union(int a, int b){
        int ax=find(a);
        int by=find(b);

        if(ax==by) return false;
        if(rank[ax]< rank[by]){
            rank[by]+=rank[ax];
            parent[ax]=by;
        }else {
            rank[ax]+=rank[by];
            parent[by]=ax;
        }

        return true;
    }
    private static int find(int a){
        if(a ==parent[a]) return a;
        else return find(parent[a]);
    }
}
