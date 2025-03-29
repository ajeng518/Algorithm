import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int node;
        int cost;

        Node(int node, int cost){
            this.node=node;
            this.cost=cost;
        }
    }

    static int max;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        List<Node>[] tree = new List[n+1];
        for(int i=1;i<=n;i++) tree[i]=new ArrayList<>();

        for(int i =0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree[start].add(new Node(end, cost));
            tree[end].add(new Node(start, cost));
        }

        max=-1;
        for(int s=1;s<=n;s++){
            visited=new boolean[n+1];
            visited[s]=true;
            dfs(n, tree, s, 0);
        }

        System.out.println(max);
    }

    private static void dfs(int n, List<Node>[] tree, int curNode, int cost){
        if(max<cost) max=cost;

        for(Node next : tree[curNode]){
            if(visited[next.node]) continue;

            visited[next.node]=true;
            dfs(n, tree, next.node, cost+next.cost);
        }
    }
}