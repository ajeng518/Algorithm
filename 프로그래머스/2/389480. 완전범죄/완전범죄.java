import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int size = info.length;
        // dp[i][a]: 첫 i개의 물건을 훔친 후, A의 누적 흔적이 a일 때의 최소 B 누적 흔적.
        // a의 범위는 0 ~ n-1
        int[][] dp = new int[size + 1][n];
        for (int i = 0; i <= size; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // 초기 상태: 아무것도 훔치지 않았을 때 A, B 모두 흔적 0.
        dp[0][0] = 0;
        
        // 각 물건에 대해 상태 전이
        for (int i = 0; i < size; i++) {
            for (int a = 0; a < n; a++) {
                if (dp[i][a] == Integer.MAX_VALUE) continue;
                int b = dp[i][a];
                
                // 경우 1: A가 물건 i를 훔침
                int newA = a + info[i][0];
                if (newA < n) {  // A의 누적 흔적이 n 미만이어야 함
                    dp[i + 1][newA] = Math.min(dp[i + 1][newA], b);
                }
                
                // 경우 2: B가 물건 i를 훔침
                int newB = b + info[i][1];
                if (newB < m) {  // B의 누적 흔적이 m 미만이어야 함
                    dp[i + 1][a] = Math.min(dp[i + 1][a], newB);
                }
            }
        }
        
        // 모든 물건을 처리한 후, 유효 상태 중 A의 흔적의 최솟값을 구함.
        int answer = Integer.MAX_VALUE;
        for (int a = 0; a < n; a++) {
            if (dp[size][a] < m) { // 유효 상태: B의 흔적이 m 미만
                answer = Math.min(answer, a);
            }
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}