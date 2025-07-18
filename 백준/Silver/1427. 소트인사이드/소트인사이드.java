import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        char[] arr = br.readLine().toCharArray();
        int size = arr.length;

        Arrays.sort(arr);
        for(int i=size-1; i>=0; i--)
            sb.append(arr[i]);

        System.out.println(sb);
    }
}
