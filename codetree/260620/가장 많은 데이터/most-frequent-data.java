import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String color = br.readLine();
            map.put(color, map.getOrDefault(color, 0)+1);
        }

        int max=0;
        for(String curColor: map.keySet()){
            if(max >= map.get(curColor)) continue;
            max=map.get(curColor);
        }

        System.out.println(max);
    }
}