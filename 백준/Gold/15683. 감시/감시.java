import java.util.*;
import java.io.*;

public class Main{
    static int[] dx={0, 1, 0, -1};//위, 우, 하, 좌
    static int[] dy={-1, 0, 1, 0};
    
    static int n, m, cctvCnt, max;
    static int[][] map, canSee;
    static int[] output;
    static List<int[]> cctv;
    
    //@SuppressWarnings("unchecked")
    static List<Integer>[] wayList = new List[6];
    
    public static void main(String args[]) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        setWayList();
        
        map=new int[n][m];
        cctv=new ArrayList<>();
        
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());

                if(map[i][j]==0 || map[i][j]==6) continue;

                cctv.add(new int[]{map[i][j], i, j}); // cctv번호, x, y
            }
        }

        max = 10000000;
        cctvCnt=cctv.size();
        output = new int[cctvCnt];

        makeCanView(0);

        System.out.println(max);
    }
    
    private static  void makeCanView(int idx){
        if(idx==cctvCnt){
            int cnt=setChkMap();

            if(cnt < max){
                max=cnt;
            }
            
            return;
        }

        for(int way : wayList[cctv.get(idx)[0]]){
            output[idx]=way;

            makeCanView(idx+1);
        }
    }

    private static int setChkMap(){
        Deque<int[]> q=new ArrayDeque<>();
        boolean[][] visited=new boolean[n][m];
        
        int[][] copyMap=new int[n][m];
        for(int i=0;i<n;i++) copyMap[i]=map[i].clone();

        for(int i=0;i<output.length;i++){
            for(int j=0; j<4; j++){
                if((output[i] & 1<<j) < 1) continue;
                
                q.add(new int[]{cctv.get(i)[1], cctv.get(i)[2], j}); // x, y, way  
            }
                 
            copyMap[cctv.get(i)[1]][cctv.get(i)[2]] = -1;
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curWay=cur[2];
            
            int nx = cur[0]+dx[curWay];
            if(nx<0 || nx>=n) continue;

            int ny=cur[1]+dy[curWay];
            if(ny<0 || ny>=m) continue;

            if(copyMap[nx][ny]==6) continue;


            copyMap[nx][ny] = -1;
            q.add(new int[]{nx, ny, curWay});
            
        }

        return chkNotViewCnt(copyMap);
    }

    private static int chkNotViewCnt(int[][] copyMap){
        int cnt=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(copyMap[i][j]!=0) continue;

                cnt++;
                
            }
        }

        return cnt;
    }
    
    private static void setWayList(){
        for(int i=0;i<=5;i++){
            wayList[i]=new ArrayList<>();
        }
        
        wayList[1].add(0b0001);
        wayList[1].add(0b0010);
        wayList[1].add(0b0100);
        wayList[1].add(0b1000);

        wayList[2].add(0b0101);
        wayList[2].add(0b1010);

        wayList[3].add(0b0011);
        wayList[3].add(0b0110);
        wayList[3].add(0b1001);
        wayList[3].add(0b1100);

        wayList[4].add(0b0111);
        wayList[4].add(0b1011);
        wayList[4].add(0b1101);
        wayList[4].add(0b1110);

        wayList[5].add(0b1111);
    }
}
