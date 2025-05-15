import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static Set<Integer> trueList;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result=0;

        parent=new int[n+1];
        for(int i=1;i<=n;i++) parent[i]=i;

        //trueList
        st=new StringTokenizer(br.readLine());
        int trueCnt=Integer.parseInt(st.nextToken());
        
        trueList=new HashSet<>();
        
        for(int i=0;i<trueCnt; i++){
            trueList.add(Integer.parseInt(st.nextToken()));
        }

        if(trueList.size()==0){
            System.out.println(m);
            System.exit(0);
        }
        
        //party List
        List<Integer>[] partyList=new List[m+1];
        
        for(int i = 1; i <= m; i++){
            partyList[i]=new ArrayList<>();
            
            st=new StringTokenizer(br.readLine());
            
            int cnt=Integer.parseInt(st.nextToken());
            int join = Integer.parseInt(st.nextToken());
            
            partyList[i].add(join);
            
            for(int j=1; j<cnt; j++){
                int cur = Integer.parseInt(st.nextToken());

                union(join, cur);
                partyList[i].add(cur);
            }
        }

        for(int i=1;i<=m;i++){
            boolean trueMan=false;

            for(int person: partyList[i] ){
                if(trueList.contains(find(parent[person]))){
                    trueMan=true;
                    break;
                }
            }

            if(trueMan) continue;

            result++;
        }

        System.out.println(result);
    }

    private static int find(int x){
        if(x == parent[x]) return parent[x];
        return x=find(parent[x]);
    }

    private static void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(trueList.contains(py)){
            int temp=py;
            py=px;
            px=temp;
        }

        parent[py]=px;
    }
}