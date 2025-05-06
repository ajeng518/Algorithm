import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static int n, m;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        int num =1;

        while(true){
            st = new StringTokenizer(br.readLine());
            
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            parent=new int[n+1];
            for(int i=1;i<=n;i++) parent[i]=i;

            if(n == 0  && m ==0 ) break;
            sb.append("Case ").append(num++).append(": ");

            while(m-- > 0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            Set<Integer> tree = new HashSet<>();
            for(int i =1;i<=n;i++){
                int pa = find(i);
                if(pa > 0) tree.add(pa);
            }
            int cnt = tree.size();
            if(cnt==0){
                sb.append("No trees.");
            }else if(cnt==1){
                sb.append("There is one tree.");
            }else{
                sb.append("A forest of ").append(cnt).append(" trees.");
            }
            
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int find(int x){
        if(x==parent[x]) return parent[x];
        else return x = find(parent[x]);
    }

    private static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa> pb){
            int temp = pa;
            pa=pb;
            pb=temp;
        }
        
        if(pa==pb) parent[pa]=0;
        else parent[pb]=pa;
    }
}