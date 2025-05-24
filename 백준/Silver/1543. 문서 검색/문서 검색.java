import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        String arr = br.readLine();
        String target=br.readLine();
        
        int cnt=0;

       while(arr.contains(target)){
           arr=arr.replaceFirst(target,"-");
           cnt++;
       }

        System.out.println(cnt);
        
    }
}