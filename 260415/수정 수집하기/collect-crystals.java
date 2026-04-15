import java.util.*;
import java.io.*;

public class Main {
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int MIN_INF = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] input = br.readLine().toCharArray();

        char[] list =new char[n+1];
        for(int i=1; i<=n; i++){
            list[i]=input[i-1];
        }

        int[][][] dp = new int[n+1][k+2][2];
        for(int i =0;i <=n ;i++){
            for(int j=0; j<=k ;j++) Arrays.fill(dp[i][j], MIN_INF);
        }
        
        //초기 위치는 왼쪽이므로 오른쪽을 초기로 두려면 이동을 한 번 한 것이므로 K=1
        dp[0][0][LEFT]=0;
        dp[0][1][RIGHT]=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<=k; j++){
                if(dp[i][j][LEFT] != MIN_INF){
                    if(list[i+1] =='L'){
                        dp[i+1][j][LEFT] = Math.max(dp[i][j][LEFT] + 1, dp[i+1][j][LEFT]);
                        dp[i+1][j+1][RIGHT] = Math.max(dp[i][j][LEFT], dp[i+1][j+1][RIGHT]);
                    }else{// list[i]='R'
                        dp[i+1][j][LEFT] = Math.max(dp[i][j][LEFT], dp[i+1][j][LEFT]);
                        dp[i+1][j+1][RIGHT] = Math.max(dp[i][j][LEFT] + 1, dp[i+1][j+1][RIGHT]);
                    }
                }

                if(dp[i][j][RIGHT] != MIN_INF){
                    if(list[i+1] =='L'){
                        dp[i+1][j+1][LEFT] = Math.max(dp[i][j][RIGHT] + 1, dp[i+1][j+1][LEFT]);
                        dp[i+1][j][RIGHT] = Math.max(dp[i][j][RIGHT], dp[i+1][j][RIGHT]);
                    }else{// list[i]='R'
                        dp[i+1][j+1][LEFT] = Math.max(dp[i][j][RIGHT], dp[i+1][j+1][LEFT]);
                        dp[i+1][j][RIGHT] = Math.max(dp[i][j][RIGHT] + 1, dp[i+1][j][RIGHT]);
                    }
                }
            }
        }

        int ans =0;
        for(int j =0; j<=k; j++){
            ans=Math.max(ans, Math.max(dp[n][j][LEFT], dp[n][j][RIGHT]));
        }

        System.out.println(ans);
    }
}