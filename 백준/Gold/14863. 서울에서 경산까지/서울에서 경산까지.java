import java.util.*;
import java.io.*;

public class Main {
    static class Road{
        int walkTime;
        int walkValue;
        int rideTime;
        int rideValue;

        Road(int walkTime, int walkValue, int rideTime, int rideValue){
            this.walkTime=walkTime;
            this.walkValue=walkValue;
            this.rideTime=rideTime;
            this.rideValue=rideValue;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());//도시 수
        int k=Integer.parseInt(st.nextToken());//최대 시간

        Road[] road=new Road[n+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            int walkTime=Integer.parseInt(st.nextToken());
            int walkValue=Integer.parseInt(st.nextToken());
            int rideTime=Integer.parseInt(st.nextToken());
            int rideValue=Integer.parseInt(st.nextToken());

            road[i]=new Road(walkTime, walkValue, rideTime, rideValue);
        }

        int[][] dp=new int[n+1][k+1];
        dp[1][road[1].walkTime]=road[1].walkValue;
        dp[1][road[1].rideTime]=Math.max(road[1].rideValue, dp[1][road[1].rideTime]);

        for(int i=2; i<=n; i++){
            Road cur=road[i];

            for(int time=1; time<=k; time++){
                if(dp[i-1][time]==0) continue;

                if(time + cur.walkTime<=k){
                    dp[i][time+cur.walkTime]=Math.max(dp[i-1][time]+cur.walkValue, dp[i][time+cur.walkTime]);
                }

                if(time+cur.rideTime<=k){
                    dp[i][time+cur.rideTime]=Math.max(dp[i-1][time]+cur.rideValue, dp[i][time+cur.rideTime]);
                }

            }
        }

        int ans = 0;

        for(int i=1;i<=k;i++){

            ans=Math.max(dp[n][i], ans);
        }

        System.out.println(ans);
    }
}