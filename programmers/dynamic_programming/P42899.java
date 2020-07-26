class Solution {
    int[][] travel;
    int[][] dp = new int[101][100001];
    public int solution(int K, int[][] travel) {
        this.travel = travel;
        return searchPath(K,0);
    }
    private int searchPath(int time,int step){
        if(step == travel.length) return 0;
        if(dp[step][time] != 0) return dp[step][time];
        if(time - travel[step][0] >= 0) dp[step][time] = Math.max(dp[step][time], travel[step][1]+searchPath(time-travel[step][0], step+1));
        if(time - travel[step][2] >= 0) dp[step][time] = Math.max(dp[step][time], travel[step][3]+searchPath(time-travel[step][2], step+1));
        return dp[step][time];
    }
}