import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        
        arr=new int[m];
        visited=new boolean[n+1];
        re(0);

        System.out.println(sb);
        
    }
    
    private static void re(int cnt){
        if(cnt==m){
            String curNum="";
            for(int i=0;i<m;i++){
                curNum+=arr[i];
                curNum+=" ";
            }

            sb.append(curNum).append("\n");
            return;
        }

        for(int i=1; i<=n;i++){
            if(visited[i]) continue;
            arr[cnt]=i;
            visited[i]=true;
            re(cnt+1);
            visited[i]=false;
        }
    }
}