import java.util.*;
import java.io.*;
/*
*리스트 배열 사용시 컴파일 경고 발생시 사용
*@SuppressWarnings("unchecked")
*/
public class Main{
    public static void main(String args[]) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n >= k){
            System.out.println(n-k);
            
            System.exit(0);
        }
        
        int[] dp = new int[100001];
        for(int i=0; i< n; i++) dp[i]=n-i;

        for(int i = n+1; i<= k; i++){
            int min;
            
            if(i % 2 == 0){
                min = dp[i/2];    
            }else{
                min = Math.min(dp[(i-1) / 2] + 1, dp[(i+1) / 2] + 1);
            }

            dp[i]=Math.min(dp[i-1] + 1, min);
        }

        System.out.println(dp[k]);
    }
}
