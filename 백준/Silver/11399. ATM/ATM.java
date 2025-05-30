import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n];

        st=new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++) time[i]=Integer.parseInt(st.nextToken());

        Arrays.sort(time);

        int cnt=time[0];
        for(int i=1;i<n;i++){
            time[i]+=time[i-1];

            cnt+=time[i];
        }

        System.out.println(cnt);
        
    }
}