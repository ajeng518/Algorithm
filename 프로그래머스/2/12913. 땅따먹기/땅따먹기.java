class Solution {
    static int idx, max,n, sum;
    static int[][]temp;
    
    int solution(int[][] land) { 
        int n=land.length;
        
        for(int i=1;i<n;i++){
            land[i][0]+=Math.max(land[i-1][1], Math.max(land[i-1][2],land[i-1][3]));
            land[i][1]+=Math.max(land[i-1][0], Math.max(land[i-1][2],land[i-1][3]));
            land[i][2]+=Math.max(land[i-1][0], Math.max(land[i-1][1],land[i-1][3]));
            land[i][3]+=Math.max(land[i-1][0], Math.max(land[i-1][1],land[i-1][2]));
        }
        
        int max=Math.max(land[n-1][0],Math.max(land[n-1][1],Math.max(land[n-1][2],land[n-1][3])));
        return max;
        
    }
    
}
//