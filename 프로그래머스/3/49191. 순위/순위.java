class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n][n];
        
        for(int i=0;i<results.length;i++)
            win[results[i][0] - 1][results[i][1]-1]=true;
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(win[i][k] && win[k][j]){
                        win[i][j]=true;
                    }
                }
            }
        }
        
        int count=0;
        for(int i=0;i<n;i++){
            int winCount=0;
            int loseCount=0;
            for(int j=0;j<n;j++){
                if(win[i][j]) winCount++;
                else if(win[j][i]) loseCount++;
            }
            if(winCount +loseCount == n-1) count++;
        }
        
        return count;
    }
}