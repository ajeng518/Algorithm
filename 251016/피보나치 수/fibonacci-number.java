import java.util.*;

public class Main {
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        memo = new int[n+1];
        Arrays.fill(memo, -1);

        System.out.println(re(n));
        
    }

    private static int re(int n){
        if(memo[n] != -1)
            return memo[n];

        if(n<=2){
            memo[n]=1;
        }else
            memo[n]=re(n-1)+re(n-2);

        return memo[n];
    }
}