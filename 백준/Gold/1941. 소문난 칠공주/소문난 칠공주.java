import java.util.*;
import java.io.*;

public class Main {
  static int cnt;
  static char[][] map;
  static int[] dx={-1, 0, 1, 0};
  static int[] dy={0, 1, 0, -1};
  static Set<Integer> visited;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    map=new char[5][5];
    
    for(int i=0;i<5;i++){
      String str=br.readLine();
       map[i]=str.toCharArray();
    }

    visited=new HashSet<>();
    for(int i=0;i<5;i++){
      for(int j=0;j<5;j++){
        dfs(map[i][j]=='S'? 1:0, map[i][j]=='Y'? 1:0, (0 | 1<<(5*i+j)));
      }
    }

    System.out.println(visited.size());
    
  }

  private static void dfs(int sCnt, int yCnt, int chk){
    if(Integer.bitCount(chk) == 7){
      if(!visited.contains(chk))
        visited.add(chk);
      return ;
    }
     
    for(int i = 0; i < 25; i++){
      if((chk & 1<<i )!=0) continue;
      
      int nx=i / 5;
      int ny=i % 5 ;

      if(!chkCanTeam(nx, ny, chk)) continue;
      if(map[nx][ny]=='Y' && yCnt+1 > 3) continue;
      

      dfs(map[nx][ny]=='S'?sCnt+1:sCnt, map[nx][ny]=='Y'?yCnt+1:yCnt, (chk | 1 << i));

    }
    
  }

  private static boolean chkCanTeam(int nx, int ny, int chk){
    for(int i=0;i<25;i++){
      if((chk & 1<< i)==0) continue;
      int x=i/5;
      int y=i%5;
      
      for(int d=0;d<4;d++){
        int ax=x+dx[d];
        int ay=y+dy[d];

        if(ax==nx && ay==ny) return true;
      }
    }

    return false;
  }
}