import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        input=input.replace("pi"," ").replace("ka", " ").replace("chu"," ").replace(" ","");

        if(input.equals("")) System.out.println("YES");
        else System.out.println("NO");
    }
}