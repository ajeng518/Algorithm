import java.util.*;
public class Main {
    static class Line implements Comparable<Line>{
        int x1;
        int x2;

        @Override
        public int compareTo(Line o){
            return this.x1-o.x1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Line[] segments = new Line[n];
        for (int i = 0; i < n; i++) {
            segments[i]=new Line();
            segments[i].x1 = sc.nextInt();
            segments[i].x2 = sc.nextInt();
        }
        // Please write your code here.
        int[] dp = new int[n];

        Arrays.sort(segments);

        for(int i=0;i<n;i++){
            dp[i]=1;

            for(int j=0;j<i; j++){
                if(segments[j].x2 >= segments[i].x1) continue;

                dp[i]=Math.max(dp[j]+1, dp[i]);
            }
        }

        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}