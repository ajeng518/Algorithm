import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        if(a>b){
            long temp = a;
            a=b;
            b=temp;
        }

        if(b-a <=1){
            System.out.println(0);
            System.exit(0);
        }
        
        if(b-a == 2){
            System.out.println(1);
            System.out.println(a+1);
            System.exit(0);
        }

        long mid =(b-a-1)/2;
        long left =a+1;
        long right = left+mid;
        boolean chkLast =false;
        if((b-a-1)%2!=0) chkLast=true;
        
        mid+=left;
        
        List<Long> l =new ArrayList<>();
        List<Long> r =new ArrayList<>();
        
        while(left<mid){
            l.add(left);
            r.add(right);

            left++;
            right++;
        }
        if(chkLast)r.add(right);

        StringBuilder sb=new StringBuilder();
        sb.append(b-a-1).append("\n");

        for(int i=0;i<l.size(); i++)
            sb.append(l.get(i)).append(" ");
        for(int i=0;i<r.size(); i++)
            sb.append(r.get(i)).append(" ");

        System.out.println(sb);
        
  }
}