class Solution {
    int LIMIT;
    int[] left = new int[2001], right = new int[2001];
    int[][] dp = new int[2001][2001];
    public int solution(int[] left, int[] right) {
        this.left =left; this.right =right; LIMIT = left.length;
        return round(0,0);
    }

    int round(int lIdx, int rIdx) {
        if (lIdx == LIMIT || rIdx == LIMIT) return 0;//어느 한쪽 더미가 다 빠진 경우
        else if(dp[lIdx][rIdx] != 0){ return dp[lIdx][rIdx];}//이전에 구한 경우에 수가 존재하는 경우
        else if(left[lIdx] > right[rIdx]) dp[lIdx][rIdx] = round(lIdx, rIdx+1)+ right[rIdx];//오른쪽을 뺄 수 있는 경우
        else dp[lIdx][rIdx] = Math.max(round(lIdx+1, rIdx), round(lIdx+1, rIdx+1));//하나만 뺀 경우와 둘 다 뺀 경우 큰 수
        return dp[lIdx][rIdx];
    }
}