import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        char[] str=br.readLine().toCharArray();
        String bomb=br.readLine();
        int bombLen=bomb.length();

        for(int i=0;i<str.length; i++){
            sb.append(str[i]);

            if(sb.length() < bombLen) continue;

            String tempStr=sb.substring(sb.length()-bombLen).toString();
            if(tempStr.equals(bomb)){
                sb.delete(sb.length()-bombLen, sb.length());
            }
        }

        if(sb.length()==0) System.out.println("FRULA");
        else System.out.println(sb);
        
    }
}