import java.util.*;
import java.io.*;

public class Main {
    static int[] parent, rank;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        
        while(t-- > 0){
            int f = Integer.parseInt(br.readLine());
            int size = f*2+1;
            
            parent=new int[size];
            rank=new int[size];
            
            for(int i=1;i<size;i++){
                parent[i]=i;
                rank[i]=1;
            }

            Map<String, Integer> nameIdxMap=new HashMap<>();
            int idx =1;
            
            for(int i=0;i<f;i++){
                st=new StringTokenizer(br.readLine());
                
                String a =st.nextToken();
                String b = st.nextToken();

                if(!nameIdxMap.containsKey(a))
                    nameIdxMap.put(a, idx++);
                
                if(!nameIdxMap.containsKey(b))
                    nameIdxMap.put(b, idx++);
                    
                int num = union(nameIdxMap.get(a), nameIdxMap.get(b));

                sb.append(num).append("\n");
            }
        }
        
        System.out.println(sb);
    }

    private static int find(int x){
        if(x == parent[x]) return parent[x];
        return x =find(parent[x]);
    }

    private static int union(int x, int y){
        int px = find(x);
        int py=find(y);

        if(px==py) return rank[px];

        if(px> py){
            parent[px]=py;
            rank[py]+=rank[px];

            return rank[py];
        }else{
            parent[py]=px;
            rank[px]+=rank[py];

            return rank[px];
        }
    }
}