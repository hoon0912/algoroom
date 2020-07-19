class Solution {
    public int solution(int[] money) {
        return Math.max(calculation(money.length-2,0, money), calculation(money.length-1,1, money));
    }

    private int calculation(int len, int start, int[] money){
        int[] dp = new int[money.length];
        for(int i = start; i<=1; i++) dp[i] = money[start];
        for(int i = 2; i<=len; i++) dp[i] = Math.max(dp[i-2]+money[i], dp[i-1]);
        return dp[len];
    }
}