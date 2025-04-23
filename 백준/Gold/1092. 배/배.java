import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n =Integer.parseInt(br.readLine());

        List<Integer> crane = new ArrayList<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            crane.add(Integer.parseInt(st.nextToken()));
        }
        

        int m = Integer.parseInt(br.readLine());
        
        List<Integer> box = new ArrayList<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            box.add(Integer.parseInt(st.nextToken()));
        }
        crane.sort( Collections.reverseOrder());
        box.sort( Collections.reverseOrder());

        if(crane.get(0)< box.get(0)){
            System.out.println(-1);
            return;
        }

        
        int sec=0;
        int boxSize=m;
        
        while(!box.isEmpty()){
            int craneIdx=0;
            int boxIdx=0;
            
            while(craneIdx<n){
                if(boxIdx==box.size()) break;
                
                if(box.get(boxIdx)<=crane.get(craneIdx)){
                    craneIdx++;
                    box.remove(boxIdx);
                } 
                else boxIdx++;
            }

            sec++;
        }

        System.out.println(sec);
    }
}