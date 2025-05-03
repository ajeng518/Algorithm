import java.util.*;
import java.io.*;

public class Main {
    static class Meeting implements Comparable<Meeting>{
        int startT;
        int endT;

        Meeting(int startT, int endT){
            this.startT=startT;
            this.endT=endT;
        }

        public int compareTo(Meeting o){
            if(this.endT== o.endT)
                return this.startT-o.startT;
            return this.endT-o.endT;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n =Integer.parseInt(br.readLine());
        
        Meeting[] schedule=new Meeting[n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());

            schedule[i]=new Meeting(s, e);
        }

        Arrays.sort(schedule);

        int cnt=0;
        int lastEndTime=0;
        for(int i=0;i<n;i++){
            if(lastEndTime > schedule[i].startT) continue;

            lastEndTime=schedule[i].endT;
            cnt++;
        }

        System.out.println(cnt);
    }
}