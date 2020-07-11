class Solution {
    int LIMIT;
    int[] left = new int[2001], right = new int[2001];
    int[][] dp = new int[2001][2001];
    public int solution(int[] left, int[] right) {
        this.left =left; this.right =right; LIMIT = left.length;
        return round(0,0);
    }

    int round(int lIdx, int rIdx) {
        if (lIdx == LIMIT || rIdx == LIMIT) return 0;//��� ���� ���̰� �� ���� ���
        else if(dp[lIdx][rIdx] != 0){ return dp[lIdx][rIdx];}//������ ���� ��쿡 ���� �����ϴ� ���
        else if(left[lIdx] > right[rIdx]) dp[lIdx][rIdx] = round(lIdx, rIdx+1)+ right[rIdx];//�������� �� �� �ִ� ���
        else dp[lIdx][rIdx] = Math.max(round(lIdx+1, rIdx), round(lIdx+1, rIdx+1));//�ϳ��� �� ���� �� �� �� ��� ū ��
        return dp[lIdx][rIdx];
    }
}