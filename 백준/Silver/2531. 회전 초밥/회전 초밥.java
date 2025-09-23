import java.util.*;
import java.io.*;
/*
*리스트 배열 사용시 컴파일 경고 발생시 사용
*@SuppressWarnings("unchecked")
*/
public class Main{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n =Integer.parseInt(st.nextToken());
        int d =Integer.parseInt(st.nextToken());
        int k =Integer.parseInt(st.nextToken());
        int c =Integer.parseInt(st.nextToken());

        int[] sushi = new int[n];
        for(int i=0;i<n;i++){
            sushi[i]=Integer.parseInt(br.readLine());
        }


        int left = 0;
        int right =0;
        
        int cnt=0;
        int cateCnt=1;
        
        int[] visited=new int[d+1];
        visited[c]=1;
        
        int max = 0;

        while(left < n-1){
            if(cnt == k){
                visited[sushi[left]]--;
                if(visited[sushi[left]] == 0){
                    cateCnt--;
                }
                
                left++;
                if(right == n-1) right = -1;
                
                visited[sushi[++right]]++;
                if(visited[sushi[right]] == 1) cateCnt++;

            }else{
                if(visited[sushi[right]] == 0){
                    cateCnt++;
                }
                
                visited[sushi[right]]++;
                right++;
                cnt++;
                if(cnt ==k) right--;
            }
            
            if(cnt == k){
                max=Math.max(cateCnt, max);
            }
        }

        System.out.println(max);
    }
}
