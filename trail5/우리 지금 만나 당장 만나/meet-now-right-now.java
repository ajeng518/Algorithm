import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] state;
    static int[] time;

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        state =new int[n];
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            state[i]=Integer.parseInt(st.nextToken());
        }

        time = new int[n];
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        System.out.printf("%.4f", binarySearch());
    }

    private static double binarySearch(){
        double left = 0;
        double right = 1_000_000_000;

        double ans = right;

        for(int i=1; i<=100; i++){
            double mid = (left+right)/2;

            if(isPossible(mid)){
                ans=Math.min(mid, ans);
                right = mid;
            }else left=mid;
        }
            
        return ans;
    }

    private static boolean isPossible(double mid){
        double maxX1 = state[0] - time[0] * mid;
        double minX2 = state[0] + time[0] * mid;

        for(int i=1; i<n;i++){
            double x1 = state[i] - time[i] * mid;
            double x2 = state[i] + time[i] * mid;


            maxX1=Math.max(maxX1, x1);
            minX2=Math.min(minX2, x2);
        }

        return maxX1 <=minX2;
    }
}