import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> chk=new TreeMap<>();

            while(n-- > 0){
                st=new StringTokenizer(br.readLine());

                char order = st.nextToken().charAt(0);
                int cur = Integer.parseInt(st.nextToken());

                if(order =='I'){
                    chk.put(cur, chk.getOrDefault(cur, 0)+1);
                }else{
                    if(chk.size() == 0) continue;
                    
                    int num = cur==1?chk.lastKey():chk.firstKey();
                    if(chk.put(num, chk.get(num)-1) ==1)
                        chk.remove(num);
                }
            }
            
            if(chk.size() == 0) sb.append("EMPTY").append("\n");
            else sb.append(chk.lastKey()).append(" ").append(chk.firstKey()).append("\n");
        }
        
        System.out.println(sb);
        
    }
}