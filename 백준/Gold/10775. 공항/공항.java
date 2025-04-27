import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int g =Integer.parseInt(br.readLine());
        int p =Integer.parseInt(br.readLine());

        parent=new int[g+1];
        for(int i =1;i<=g;i++)parent[i]=i;

        int ans =0;
        for(int i =0; i<p; i++){
            int cur = Integer.parseInt(br.readLine());
            int emptyGate=find(cur);

            if(emptyGate == 0) break;

            ans++;
            union(emptyGate, emptyGate-1);
        }

        System.out.println(ans);
    }

    private static int find(int x){
        if(x== parent[x]) return x;
        return parent[x]=find(parent[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y=find(y);

        if(x !=y){
            parent[x]=y;
        }
    }
}