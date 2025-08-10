import java.util.*;
import java.io.*;

public class Main{
    static class Node implements Comparable<Node>{
        int node;
        int cost;

        Node(int node, int cost){
            this.node=node;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost-o.cost;
        }
    }
    
    public static void main(String args[]) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st=new StringTokenizer(br.readLine());

        int v= Integer.parseInt(st.nextToken());
        int e= Integer.parseInt(st.nextToken());

        List<Node>[] nodeList=new List[v+1];
        for(int i=1;i<=e;i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            if(nodeList[a]==null){
                nodeList[a]=new ArrayList<>();
            }
            nodeList[a].add(new Node(b, cost));

            if(nodeList[b]==null){
                nodeList[b]=new ArrayList<>();
            }
            nodeList[b].add(new Node(a, cost));
        }

         PriorityQueue<Node> pq=new PriorityQueue<>();
            pq.add(new Node(1, 0));
            boolean[] visited=new boolean[v+1];
    
            int answer=0;
            while(!pq.isEmpty()){
                Node cur = pq.poll();
    
                if(visited[cur.node]) continue;
                
                answer+=cur.cost;
                visited[cur.node]=true;
    
                for(Node next: nodeList[cur.node]){
                    if(visited[next.node]) continue;
    
                    pq.add(next);
                }
            }
        System.out.println(answer);
    }
}
