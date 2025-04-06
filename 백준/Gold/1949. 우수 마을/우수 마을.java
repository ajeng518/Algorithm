import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static int[] people;
    static List<Integer>[] neighbor;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n =Integer.parseInt(br.readLine());
        people = new int[n+1];
        
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            people[i]=Integer.parseInt(st.nextToken());
        }

        neighbor = new List[n+1];
        for(int i=1;i<=n;i++) neighbor[i]=new ArrayList<>();

        int turn=n-1;
        while(turn-- > 0){
            st=new StringTokenizer(br.readLine());
            
            int a =Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            
            neighbor[a].add(b);
            neighbor[b].add(a);
        }

        
        dp=new int[n+1][2];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i], -1);

        System.out.println(Math.max(dpDfs(1, -1, 1)+people[1], dpDfs(1, -1, 0)));
  }

    private static int dpDfs(int pos, int prev, int flag){
        int len = neighbor[pos].size();

        if(dp[pos][flag] != -1) return dp[pos][flag];

        dp[pos][flag]=0;
        for(int i=0; i<len;i++){
            int next=neighbor[pos].get(i);

            if(next==prev) continue;
            
            if(flag == 1) dp[pos][flag]+=dpDfs(next, pos, 0);
            else dp[pos][flag]+=Math.max(dpDfs(next, pos, 1)+ people[next], dpDfs(next, pos, 0));
        }

        return dp[pos][flag];
    }
}