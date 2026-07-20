import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static String a, b;
    static int[] del;
    static boolean[] skip;

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        a = br.readLine();
        b = br.readLine();

        n = a.length();
        m = b.length();

        del =new int[n+1];
        st=new StringTokenizer(br.readLine());

        for(int i=1; i<=n;i++) del[i]=Integer.parseInt(st.nextToken());

        skip=new boolean[n+1];

        System.out.println(binarySearch());
    }

    private static int binarySearch(){
        int left =0;
        int right = n;
        int ans=-1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(isPossible(mid)){
                left=mid+1;
                ans=Math.max(ans, mid);
            }else right=mid - 1;
            
            for(int i=1; i<=mid; i++) skip[del[i] - 1]=false;
        }

        

        return ans+1;
    }

    private static boolean isPossible(int mid){
        int idx=0;

        for(int i=1; i<=mid; i++){
            skip[del[i]-1] =true;
        }

        for(int i=0;i<n; i++){
            if(skip[i]) continue;

            if(idx < m && a.charAt(i) ==b.charAt(idx)) idx++;
        }

        return idx==m;
    }
}