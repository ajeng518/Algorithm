import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int n =Integer.parseInt(br.readLine());//
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

       while(n-- > 0){
           int cur = Integer.parseInt(br.readLine());

           if(cur==0){
               if(pq.isEmpty()) sb.append(0).append("\n");
               else sb.append(pq.poll()).append("\n");
               continue;
           }

           pq.add(cur);
       }

        System.out.println(sb);
    }
}