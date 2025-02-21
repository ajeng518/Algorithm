import java.util.*;
import java.io.*;

public class Main {
  static int[] parents;
  static int n, m;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n=Integer.parseInt(br.readLine());
    m=Integer.parseInt(br.readLine());
    
    parents=new int[n+1];
    for(int i=1;i<=n; i++) parents[i]=i;
    
    for(int i=1; i<=n; i++){
      st=new StringTokenizer(br.readLine());
      for(int j=1;j<=n;j++){
        if(Integer.parseInt(st.nextToken())==0) continue;
        int parentA=findParents(i);
        int parentB=findParents(j);

        if(parentA>parentB){
          parents[parentA]=parentB;
        }else parents[parentB]=parentA;
      }
    }

    st=new StringTokenizer(br.readLine());

    int now=Integer.parseInt(st.nextToken());
    int nowP=findParents(now);
    
    for(int i=1; i<m; i++){
      now=Integer.parseInt(st.nextToken());
      
      if(nowP!=findParents(now)){ 
        System.out.println("NO");
        System.exit(0);
      }
    }
    
    System.out.println("YES");
    
  }

  private static int findParents(int cur){
    if(cur==parents[cur]) return cur;
    return findParents(parents[cur]);
  } 
}