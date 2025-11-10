import java.util.*;
import java.io.*;

public class Main {
    static Map<Integer, Integer> map;
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        while(n-- > 0){
            st=new StringTokenizer(br.readLine());
            String menu = st.nextToken();

            if(menu.equals("add")){
                int k  = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                map.put(k, v);
            }else if(menu.equals("remove")){
                int k  = Integer.parseInt(st.nextToken());
                map.remove(k);
            }else{
                int k  = Integer.parseInt(st.nextToken());
                if(map.containsKey(k)){
                    sb.append(map.get(k)).append("\n");
                }else sb.append("None").append("\n");
            }
        }

        System.out.println(sb);
    }
}