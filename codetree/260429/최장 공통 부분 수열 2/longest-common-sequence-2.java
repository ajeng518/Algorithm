import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        
        String a =br.readLine();
        String b =br.readLine();
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n+1][m+1];
        int[][][] path = new int[n+1][m+1][2];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(dp[i][j] < dp[i-1][j]){
                    dp[i][j] = dp[i-1][j];
                    path[i][j][0]=i-1;
                    path[i][j][1]=j;
                }

                if(dp[i][j] < dp[i][j-1]){
                    dp[i][j] = dp[i][j-1];
                    path[i][j][0]=i;
                    path[i][j][1]=j-1;
                }

                if(a.charAt(i-1) == b.charAt(j-1) && dp[i][j] < dp[i-1][j-1] + 1){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    path[i][j][0]=i-1;
                    path[i][j][1]=j-1;
                }
            }
        }

        List<Character> lcs = new ArrayList<>();
            for(int i=n, j=m; i > 0 && j > 0;){
                if(path[i][j][0] == i-1 && path[i][j][1] == j-1 && a.charAt(i-1) == b.charAt(j-1)){
                    lcs.add(a.charAt(i-1));
                    i--;j--;
                }else{
                    int ni=path[i][j][0];
                    int nj=path[i][j][1];

                    i=ni;
                    j=nj;
                }
            }

        for(int i=lcs.size()-1; i>=0; i--){
            System.out.print(lcs.get(i));

        }
    }
}