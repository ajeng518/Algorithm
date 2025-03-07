import java.util.*;
import java.io.*;

public class Main {
  static int h, w;
  static int[][] map;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());

    h=Integer.parseInt(st.nextToken());//
    w=Integer.parseInt(st.nextToken());//
    
    map=new int[h][w];
    st=new StringTokenizer(br.readLine());
    for(int i=0; i < w; i++){
      int block=Integer.parseInt(st.nextToken());
      for(int j=h-1;j>=h-block; j--){
        map[j][i]=1;
      }
    }
    int ans=0;
    
    for(int i=0; i<h;i++){
      for(int j=0; j<w; j++){
        if(map[i][j]!=1) continue;

        boolean isPossible=false;
        int cnt=0;
        int next=j;
        
        for(int k = j+1; k < w; k++){
          if(map[i][k]==1){
            if(cnt>0){
              isPossible=true;
              next=k-1;
            }
            break;
          }
          cnt++;
        }

        if(!isPossible) continue;
        ans+=cnt;
        j=next;
      }
    }

    System.out.println(ans);
  }
}