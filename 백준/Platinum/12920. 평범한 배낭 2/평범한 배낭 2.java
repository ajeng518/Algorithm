import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n =Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]> item=new ArrayList<>();
        item.add(new int[]{0, 0});
        for(int i = 0; i<n;i++){
            st=new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());//무게
            int c = Integer.parseInt(st.nextToken());//만족도
            int k = Integer.parseInt(st.nextToken());

            int tempCnt=1;
            while(tempCnt <= k){
                item.add(new int[]{tempCnt*v, tempCnt*c});
                k-= tempCnt;

                tempCnt*=2;
            }if(k!= 0) item.add(new int[]{k*v, k*c});
        }

        int size = item.size();
        int[][] dp = new int[size][m+1];

        for(int i=1;i<size; i++){
            for(int j =1; j<=m;j++){
                int[] cur = item.get(i);
                if(cur[0] > j ){
                    dp[i][j]=dp[i-1][j];
                    continue;
                }
                dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-cur[0]]+cur[1]);
            }
        }

        System.out.println(dp[size-1][m]);
    }
}