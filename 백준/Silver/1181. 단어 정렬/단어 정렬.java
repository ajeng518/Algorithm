import java.util.*;
import java.io.*;

public class Main {
    static class Str implements Comparable<Str>{
        String str;

        Str(String str){
            this.str=str;
        }

        @Override
        public int compareTo(Str o){
            if(this.str.length() > o.str.length())
                return 1;
            else if(this.str.length() ==o.str.length()) return this.str.compareTo(o.str);

            return -1;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Str> pq=new PriorityQueue<>();
        Set<String>visited=new HashSet<>();

        for(int i=0;i<n;i++){
            String cur=br.readLine();
            if(visited.contains(cur)) continue;
            
            pq.add(new Str(cur));
            visited.add(cur);
        }

        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll().str).append("\n");
        }

        System.out.println(sb);
    }
}