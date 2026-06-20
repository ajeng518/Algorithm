import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int happy=0;

        for(int i=0;i<n;i++){
            
            if(searchLeft(i)){
                happy++;
            }
            if(searchDown(i)){
                happy++;
            }
        }

        System.out.println(happy);
    }

    private static boolean searchLeft(int cur){
        int target=map[cur][0];
        int cnt=1;
        

        for(int i=1; i<n; i++){
            if(target != map[cur][i]){
                if(cnt >= m){
                    return true;
                }

                target=map[cur][i];
                cnt=1;
                continue;
            }

            cnt++;
            if(cnt >= m){
                return true;
            }
        }

        if(cnt >= m){
                return true;
        }
        
        return false;
    }

    private static boolean searchDown(int cur){
        int target=map[0][cur];
        int cnt=1;

        for(int i=1; i<n; i++){
            if(target != map[i][cur]){
                if(cnt >= m){
                    return true;
                }

                target=map[i][cur]; 
                cnt=1;
                continue;
            }

            cnt++;
            if(cnt >= m){
                return true;
            }
        }

        if(cnt >= m){
            return true;
        }
        
        return false;
    }
}