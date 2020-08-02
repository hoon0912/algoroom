class Solution43165 {
    private int[] numbers;
    private int target;
    private int answer;
    private void dfs(int index, int number) {
        if (index == numbers.length) {
            if (number == target) {
                answer++;
            }
        } else {
            dfs(index+1, number + numbers[index]);
            dfs(index+1, number - numbers[index]);   
        }
    }
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);
        return answer;
    }
}
