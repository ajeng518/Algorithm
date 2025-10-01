import java.util.*;
import java.io.*;
public class Main{
    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        Meeting(int start, int end){
            this.start=start;
            this.end=end;
        }
        
        @Override
        public int compareTo(Meeting o){
            if(o.end == this.end)
                return this.start-o.start;
            return this.end-o.end;
        }
        
    }
    public static void main(String args[]) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        Meeting[] meetingArr=new Meeting[n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            meetingArr[i]=new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meetingArr);
        
        int cnt=0;
        int now=0;
        
        for(int i=0;i<n;i++){
            if(meetingArr[i].start < now) continue;
            cnt++;
            now=meetingArr[i].end;
        }

        System.out.println(cnt);
    }
}
