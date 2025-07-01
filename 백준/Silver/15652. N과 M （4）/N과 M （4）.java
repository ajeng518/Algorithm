import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        arr=new int[m];

        re(1, 0);

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

        for(int i=now;i<=n;i++){
            arr[cnt]=i;
            re(i, cnt+1);
        }
    }
}