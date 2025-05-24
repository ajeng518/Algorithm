import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        int[][] apt = new int[15][15];
        
        for(int i = 1; i<=14;i++){
            apt[0][i]=i;
        }

        for(int i =1; i<=14; i++){
            for(int j =1; j<=14; j++){
                apt[i][j]=apt[i][j-1]+apt[i-1][j];
            }
        }
        
        while(t-- >0 ){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());


            sb.append(apt[k][n]).append("\n");
        }

        System.out.println(sb);
        
    }
}