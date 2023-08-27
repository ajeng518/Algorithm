import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int l=Integer.parseInt(st.nextToken());
        int[]yumm=new int[n];
        int[]chk=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            yumm[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               if(chk[j]==1)continue;
               if(l>=yumm[j]){
                   chk[j]=1;
                   l++;
               }
           }
        }
        System.out.println(l);
    }
}
