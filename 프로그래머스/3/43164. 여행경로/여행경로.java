import java.util.*;

class Solution{
    static List<String> road;
    static boolean[] visited;
    static int n;
    
    public String[] solution(String[][] tickets) {
        road = new ArrayList<>();
        n = tickets.length;
        visited = new boolean[n+1];
        
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(road);
        
        return road.get(0).split(" ");        
    }
    
    private static void dfs(int cnt, String start, String path, String[][]tickets ){
        if(cnt==n){
            road.add(path);
            return;
        }
        
        
        for(int i =0; i< n; i++){
            if(visited[i]) continue;
            if(!tickets[i][0].equals(start)) continue;
            visited[i]=true;
            dfs(cnt+1, tickets[i][1], path+" "+tickets[i][1], tickets);
            visited[i]=false;
        }
    }
}

// class Solution {
//     int n;
//     boolean[] visited;
//     ArrayList<String> arr = new ArrayList<>();
    
//     public void dfs(int cnt, String start, String path, String[][] tickets) {
//         if(cnt == n) {
//             arr.add(path);
//             return;
//         }
        
//         for(int i = 0; i < n; i++) {
//             if (!visited[i] && tickets[i][0].equals(start)) {
//                 visited[i] = true;
//                 dfs(cnt+1, tickets[i][1], path + " " + tickets[i][1], tickets);
//                 visited[i] = false;
//             }
//         }
//     }
    
//     public String[] solution(String[][] tickets) {
//         n = tickets.length;
//         visited = new boolean[n+1];
        
//         dfs(0, "ICN", "ICN", tickets);
        
//         Collections.sort(arr);

//         return arr.get(0).split(" ");
//     }
// }