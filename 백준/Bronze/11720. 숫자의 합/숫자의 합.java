import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] num = br.readLine().toCharArray();
        int sum =0;

        for(int i=0;i<n;i++){
            sum+=num[i]-'0';
        }

        System.out.println(sum);
    }
}