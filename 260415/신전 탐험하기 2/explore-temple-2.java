import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] room = new int[n+1][3];

        for(int i=1; i<=n; i++){
            st=new StringTokenizer (br.readLine());
            room[i][0]=Integer.parseInt(st.nextToken());
            room[i][1]=Integer.parseInt(st.nextToken());
            room[i][2]=Integer.parseInt(st.nextToken());
        }

        int[][][] dp = new int[n+1][3][3];
        dp[1][0][0]=room[1][0];
        dp[1][1][1]=room[1][1];
        dp[1][2][2]=room[1][2];

        for(int i=2; i<=n; i++){
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    for(int l=0; l<3; l++){
                        if(k == l) continue;

                        dp[i][j][l]=Math.max(dp[i-1][j][k]+room[i][l], dp[i][j][l]);
                    }
                }
            }
        }

        int ans=0;
        for(int j=0; j<3; j++){
            for(int k=0; k<3; k++){
                if(j ==k) continue;

                ans=Math.max(ans, dp[n][j][k]);
            }
        }

        System.out.println(ans);
    }
}