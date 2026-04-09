import java.io.*;
import java.util.*;

class Solution{
    static boolean[] visited;
    static int size, max;
    
    public int solution(int k , int[][] dungeons){
        int answer=0;
        size = dungeons.length;
        max=0;
        visited=new boolean[size];
        
        dfs(0, k, dungeons);
        return max;
    }

    private static void dfs(int cnt, int nowHp, int[][] dungeons){
        if(nowHp<=0){
            return;
        }
        max=Math.max(max, cnt);
        
        for(int i=0;i<size;i++){
            if(visited[i]) continue;
            if(dungeons[i][0] > nowHp) continue;
            
            visited[i]=true;
            dfs(cnt+1, nowHp-dungeons[i][1], dungeons);
            visited[i]=false;
        }
    }
}

// class Solution {
//     static boolean[][] visited;
//     static int n, max;
    
//     public int solution(int k, int[][] dungeons) {//k:현재 피로도, dungeons:던전당 최소필요피로도, 소모피로도
//         int answer = -1;
//         n=dungeons.length;//던전 수
//         max=-1;
        
//         re(k, 0, 0, dungeons, new boolean[n]);
        
//         return max;
//     }
    
//     private static void re(int now, int curDungeon, int cnt, int[][]dungeons, boolean[] visited){
//         if(now<=0) return;
//         max=Math.max(cnt, max);
        
        
//         for(int i=0; i<n; i++){
//             if(visited[i]) continue;

//             if(dungeons[i][0]>now)continue;
            
//             visited[i]=true;
//             re(now-dungeons[i][1], i, cnt+1, dungeons, visited);
//             visited[i]=false;
//         }
        
//     }
// }//