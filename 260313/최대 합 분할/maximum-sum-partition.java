import java.util.*;
public class Main {
    static final int OFFSET =100000;
    static int n, sum;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sum=0;
        arr = new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }
        
        boolean isOdd=false;//홀수 인지 유무
        if(sum%2!=0) isOdd=true;

        dp= new int[n+1][sum + 1 + OFFSET];
        for(int i=0;i<=n;i++){
            for(int j=-sum; j <=sum; j++){
                dp[i][j+OFFSET]=-1;
            }
        }
        dp[0][0+OFFSET]=0;

        dp[0][0]=0;

        for(int i=1; i<=n; i++){
            for(int j=-sum; j<=sum; j++){
                //그룹 A에 i번째 원소 추가해서 sum(A)-sum(B) =j인 경우
               update(i, j, i-1, j-arr[i], arr[i]);

                //그룹 B에 i번째 원소를 추가해서 sum(A)-sum(B) = j 인 경우
               update(i, j, i-1, j+arr[i], 0);

                //그룹 C에 i번째 원소를 추가하여 sum(A)-sum(B) = j 인 경우
               update(i, j, i-1, j, 0);
            }
        }

        System.out.println(dp[n][OFFSET]);
    }

    private static void update(int i, int j, int prevI, int prevJ, int val){
        if(prevJ < -sum || prevJ > sum) return;
        if(dp[prevI][prevJ + OFFSET]==-1) return;

        dp[i][j + OFFSET] = Math.max(dp[i][j+OFFSET], dp[prevI][prevJ + OFFSET] + val);
    }
}