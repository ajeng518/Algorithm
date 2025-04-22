import java.util.*;
import java.io.*;

public class Main {
    static int[] parents;
    static Set<Integer> trueKnown;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        int ans=0;
        parents=new int[n+1];
        for(int i=1;i<=n;i++) parents[i]=i;

        st=new StringTokenizer(br.readLine());
        int trueCnt=Integer.parseInt(st.nextToken());

        if(trueCnt==0){
            System.out.println(m);
            System.exit(0);
        }

        trueKnown =new HashSet<>();
        while(trueCnt-- > 0){
            trueKnown.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer>[] partyList=new List[m];
        for(int i=0;i<m;i++){
            partyList[i]=new ArrayList<>();
            
            st=new StringTokenizer(br.readLine());
            int joinCnt = Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            partyList[i].add(x);

            while(--joinCnt > 0){
               int cur=Integer.parseInt(st.nextToken());

                union(x, cur);
                partyList[i].add(cur);
            }
            
        }

        for(int i =0; i<m;i++){
            boolean isTrueMan=false;

            for(int p : partyList[i]){
                if(trueKnown.contains(find(parents[p]))){
                    isTrueMan=true;
                    break;
                }
            }

            if(!isTrueMan) ans++;
        }

        System.out.println(ans);
        
    }

    private static void union(int x, int y){
        int px=find(x);
        int py=find(y);

        if(trueKnown.contains(py)){
            int temp = px;
            px=py;
            py=temp;
        }
        parents[py]=px;
    }

    private static int find(int x){
        if(parents[x]==x) return x;
        return find(parents[x]);
    }
}