import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n =Integer.parseInt(br.readLine());
        
        int[][] map= new int[n][3];
        for(int i =0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            
            map[i][0]=Integer.parseInt(st.nextToken());
            map[i][1]=Integer.parseInt(st.nextToken());
            map[i][2]=Integer.parseInt(st.nextToken());
        }

        int[][] max=new int[n][3];
        int[][] min=new int[n][3];
        
        max[0][0]=min[0][0]=map[0][0];
        max[0][1]=min[0][1]=map[0][1];
        max[0][2]=min[0][2]=map[0][2];

        for(int i=1; i<n;i++){
            max[i][0]=Math.max(max[i-1][0], max[i-1][1]) + map[i][0];
            max[i][1]=Math.max(max[i-1][0], Math.max(max[i-1][1], max[i-1][2])) + map[i][1];
            max[i][2]=Math.max(max[i-1][1], max[i-1][2]) + map[i][2];

            min[i][0]=Math.min(min[i-1][0], min[i-1][1]) + map[i][0];
            min[i][1]=Math.min(min[i-1][0], Math.min(min[i-1][1], min[i-1][2])) + map[i][1];
            min[i][2]=Math.min(min[i-1][1], min[i-1][2]) + map[i][2];
        }

        System.out.println(Math.max(max[n-1][0], Math.max(max[n-1][1], max[n-1][2]))
                           +" "
                           +Math.min(min[n-1][0], Math.min(min[n-1][1], min[n-1][2])));
    }
}