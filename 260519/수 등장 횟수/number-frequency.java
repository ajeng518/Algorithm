import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map =new HashMap<>();
        
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n;i++){
            int cur =Integer.parseInt(st.nextToken());
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        st=new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m;i++){
            int cur =Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(cur, 0)).append(" ");
        }

        System.out.println(sb);

    }
}