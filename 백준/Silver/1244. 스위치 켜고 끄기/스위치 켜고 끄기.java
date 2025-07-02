import java.util.*;
import java.io.*;

public class Main {
    static int n;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        n= Integer.parseInt(br.readLine());
        int[] switchList = new int[n+1];

        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            switchList[i]=Integer.parseInt(st.nextToken());
        }

        int student=Integer.parseInt(br.readLine());
        while(student-- > 0){
            st=new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(s==1){
                boys(num,switchList);
            }else{
                girls(num,switchList);
            }
        }

       for(int i=1;i<=n;i++){
           sb.append(switchList[i]).append(" ");
           if(i%20==0) sb.append("\n");
       }

        System.out.println(sb);
        
    }

    private static void girls(int num, int[] switchList){
        int left=num;
        int right=num;
        
        while(left>0 && right<=n){
            if(switchList[left]!=switchList[right]){
                left++;
                right--;
                break;
            }
            left--;
            right++;
        }

        if(left<1 || right>n){
            left++;
            right--;
        }

        for(int i=left; i<=right;i++){
            switchList[i]=switchList[i]%2==0? 1: 0;
        }
    }

    private static void boys(int num, int[] switchList){
        int cur=num;

        while(cur<=n){
            switchList[cur]=switchList[cur]%2==0? 1 : 0;
            cur+=num;
        }
    }
}