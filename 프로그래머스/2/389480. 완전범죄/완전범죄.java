import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int size=info.length;
        int[][] dp=new int[size+1][n];// dp[물건수][a 최대가능 수]
        for(int i=0; i<=size; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0]=0;
        
        for(int i=0;i<size; i++){
            for(int a = 0; a < n; a++){
                if(dp[i][a]==Integer.MAX_VALUE) continue;
                
                int b=dp[i][a];
                
                //a 훔침
                int newA=a+info[i][0];
                if(newA<n){
                    dp[i+1][newA] = Math.min(b, dp[i+1][newA]);
                }
                
                //b 훔침
                int newB=b+info[i][1];
                if(newB<m){
                    dp[i+1][a]=Math.min(dp[i+1][a], newB);
                }
            }
        }
        
        int answer=Integer.MAX_VALUE;
        for(int a=0; a<n;a++){
            if(dp[size][a]>=m) continue;
            answer=a;
            break;
                
        }
        return answer!=Integer.MAX_VALUE?answer:-1;
    }
}