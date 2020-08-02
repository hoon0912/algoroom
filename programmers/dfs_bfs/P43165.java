class Solution {
    private int target, answer;
    private int[] numbers;
    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        dfs(0,0);
        return answer;
    }

    private void dfs(int step, int sum){
        if(step == numbers.length && sum == target) answer++;
        if(step >= numbers.length) return;
        dfs(step+1, sum+numbers[step]);
        dfs(step+1, sum-numbers[step]);
    }
}