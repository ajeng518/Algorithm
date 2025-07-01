import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] num, arr;
    static boolean[] visited;
    static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        num=new int[n];
        arr=new int[m];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
         num[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        visited=new boolean[n+1];
        re(0, 0);

        System.out.println(sb);
    }

    private static void re(int now, int cnt){
        if(cnt==m){
            String ansNum="";
            for(int i=0;i<m;i++){
                ansNum+=arr[i];
                ansNum+=" ";
            }

            sb.append(ansNum).append("\n");
            return;
        }
        if(now>=n) return;

        for(int i=now;i<n;i++){
            arr[cnt]=num[i];
            re(i+1, cnt+1);
        }
    }
}