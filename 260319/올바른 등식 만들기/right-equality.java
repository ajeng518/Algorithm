import java.util.*;
public class Main {
    static final int OFFSET =20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] num = new int[N+1];
        for (int i = 1; i <= N; i++) {
            num[i] = sc.nextInt();
        }
        
        int[][] dp=new int[N+1][41];
        // for(int i=1;i<=N;i++) Arrays.fill(dp[i], -1);
        
        dp[1][num[1]+OFFSET]=1;
        dp[1][-num[1]+OFFSET]=1;

        for(int i=2;i<= N;i++){
            for(int j=-20; j<=20; j++){
                int cur = j+OFFSET;

                if(dp[i-1][cur] <= 0) continue;

                int plus = j+num[i];
                int minus = j-num[i];

                if(plus <= 20 && plus >=-20)
                    dp[i][plus + OFFSET] += dp[i-1][cur];
                
                if(minus <=20 && minus >=-20)
                    dp[i][minus + OFFSET] += dp[i-1][cur];
            }
        }

        System.out.println(dp[N][M+OFFSET]);

    }
}