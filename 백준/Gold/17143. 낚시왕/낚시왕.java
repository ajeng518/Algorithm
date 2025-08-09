import java.util.*;
import java.io.*;

public class Main{
    static class Shark{
        int idx;
        int size;
        int speed;
        int x;
        int y;
        int way;

        Shark(int idx, int x, int y, int speed, int way, int size){
            this.idx=idx;
            this.size=size;
            this.speed=speed;
            this.x=x;
            this.y=y;
            this.way=way;
        }
    }

    static int[][] map;
    static Shark[] sharkList;
    static int person;
    static boolean[] visited;
    static int r, c, m;

    static int[] dx={ -1, 1, 0, 0};//상, 하, 우, 좌
    static int[] dy={0, 0, 1, -1};
    
    public static void main(String args[]) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sharkList=new Shark[m+1];
        map=new int[r+1][c+1];
        person=0;
        visited=new boolean[m+1];

        for(int i=1; i<=m;i++){
            st=new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sharkList[i]=new Shark(i, x, y, Integer.parseInt(st.nextToken()),
                                   Integer.parseInt(st.nextToken()) -1 , Integer.parseInt(st.nextToken()));
            
            map[x][y]=i;
        }
        
        System.out.println(process());
    }

    private static int process(){
        int ans=0;//잡은 상어 크기 합
        
        while(person < c){
            //사람 움직임.
            person++;
            
            //사람이 있는 열의 가장 가까운 상어를 잡는다.
            for(int i=1;i<=r;i++){
               if( map[i][person]==0) continue;
    
                ans+=sharkList[map[i][person]].size;
                
                visited[map[i][person]]=true;
                map[i][person]=0;

                break;
            }
            
            //상어 이동
            movingShark();

            //같은 칸 상어 2마리 이상 시 큰놈만 남음
            samePlaceChk();
        }

        return ans;
    }

    private static void movingShark(){
        for(int i=1; i<= m;i++){
            if(visited[i]) continue;
            
            Shark cur = sharkList[i];
            map[cur.x][cur.y]=0;
            
            int nx=cur.x;
            int ny=cur.y;
            
            for(int j=1; j <= cur.speed; j++){
                nx=nx+dx[cur.way];
                if(nx<1 || nx>r){
                    nx=nx-dx[cur.way];
                    cur.way = cur.way % 2 == 0? cur.way+1:cur.way-1;
                    nx=nx+dx[cur.way];
                }

                ny=ny+dy[cur.way];
                if(ny<1 || ny>c){
                    ny=ny-dy[cur.way];
                    cur.way = cur.way % 2 == 0? cur.way+1:cur.way-1;
                    ny=ny+dy[cur.way];
                }
            }

            cur.x=nx;
            cur.y=ny;
        }
    }

    private static void samePlaceChk(){
        for(int i=1; i <= m; i++){
            if(visited[i]) continue;

            Shark cur = sharkList[i];
            if(map[cur.x][cur.y] != 0){
                if(cur.size < sharkList[map[cur.x][cur.y]].size){
                    visited[i]=true;
                    continue;
                }else{
                    visited[map[cur.x][cur.y]]=true;
                }
            }
            
            map[cur.x][cur.y]=cur.idx;
        }
    }
}
