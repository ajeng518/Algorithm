import java.io.*;
import java.util.*;

public class Main {
    static final int BELONG =1;
    static final int NOT_BELONG =0;

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            num[i]=Integer.parseInt(st.nextToken());
        }

        int[][][] dp = new int[n+1][m+1][2];
        for(int i=0; i<=n; i++)
            for(int j=0;j<=m;j++) Arrays.fill(dp[i][j], -500000);

        for(int i=0;i<=n;i++) dp[i][0][NOT_BELONG] = 0;

        for(int i =1; i<=n; i++){
            for(int j=1;j<=m;j++){
                dp[i][j][BELONG] = Math.max(dp[i-1][j-1][NOT_BELONG] + num[i], dp[i-1][j][BELONG]+ num[i]);

                dp[i][j][NOT_BELONG] = Math.max(dp[i-1][j][NOT_BELONG], dp[i-1][j][BELONG]);
            }
        }

        System.out.println(Math.max(dp[n][m][NOT_BELONG], dp[n][m][BELONG]));
    }
}