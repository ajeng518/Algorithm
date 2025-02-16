class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server=new int[24];
        int cnt=0;
        
        for(int i=0;i<24;i++){
            if(players[i]>=(server[i]+1)*m){
                int plus=players[i]/m-server[i];
                cnt+=plus;
                
                for(int j=i;j<i+k && j<24;j++)
                    server[j]+=plus;
            }
        }
        return cnt;
    }
}