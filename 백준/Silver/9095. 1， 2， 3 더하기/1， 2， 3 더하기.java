import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int target=Integer.parseInt(br.readLine());

            int[] dp=new int[target+1];
            dp[0]=1;

            for(int cur =1; cur<= target; cur++){
                for(int i =1; i<=3; i++){
                    if(cur-i<0) continue;

                    dp[cur]+=dp[cur-i];
                }
            }

            sb.append(dp[target]).append("\n");
        }

        System.out.println(sb);
    }
}