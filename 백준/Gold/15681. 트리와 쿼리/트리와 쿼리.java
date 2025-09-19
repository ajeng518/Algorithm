import java.util.*;
import java.io.*;

 @SuppressWarnings("unchecked")

public class Main{
    static int n, r, q;
    static int[] dp;
    static List<Integer>[] edgeList;
    static int[] query;
    static boolean[] visited;
    
    public static void main(String args[]) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        n=Integer.parseInt(st.nextToken());//정점 수
        r=Integer.parseInt(st.nextToken());//루트 번호
        q=Integer.parseInt(st.nextToken());//쿼리 수

        edgeList=new List[n+1];
        for(int i=0;i<=n;i++) edgeList[i]=new ArrayList<>();

        for(int i = 0; i<n-1; i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edgeList[a].add(b);
            edgeList[b].add(a);
        }

        query=new int[q];
        dp=new int[n+1];
        Arrays.fill(dp, 1);
        
        visited=new boolean[n+1];
        
        searchTree(r, r);
        
        for(int i=0;i<q;i++){
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);
        
    }

    private static int searchTree(int now, int last){

        for(int next : edgeList[now]){
            if(next == last) continue;
            
            dp[now]+=searchTree(next, now);
        }

        return dp[now];
    }
}
