import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++){
            if(i%3==0 || chkNum(i)){
                dp[i]=dp[i-1]+1;
            }else dp[i]=dp[i-1];
        }

        System.out.println(dp[n] % MOD);
    }

    private static boolean chkNum(int num){
        char[] number = Integer.toString(num).toCharArray();

        for(int i=0;i<number.length;i++){
            if(number[i]=='3' || number[i]=='6' || number[i]=='9') return true;
        }

        return false;
    }
}