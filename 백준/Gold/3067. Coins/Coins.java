import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());

            int[] coin=new int[n+1];

            st=new StringTokenizer(br.readLine());
            for(int i=1;i<= n; i++){
                coin[i]=Integer.parseInt(st.nextToken());
            }
            
            int goal = Integer.parseInt(br.readLine());

            int[] dp= new int[goal+1];

            for(int i=1; i <= n; i++){
                dp[coin[i]]+=1;
                
                for(int cash = coin[i]+1; cash<= goal; cash++){
                    
                    dp[cash]+=dp[cash-coin[i]];
                }
            }

            sb.append(dp[goal]).append("\n");
        }

        System.out.println(sb);
    }
}