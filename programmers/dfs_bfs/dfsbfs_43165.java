import java.util.stream.IntStream;

public class dfsbfs_43165 {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }

    public static int dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) return 1;
            else return 0;
        }

        int min_sum = sum + IntStream.range(idx, numbers.length).map(i -> -1 * numbers[i]).sum();
        int max_sum = sum + IntStream.range(idx, numbers.length).map(i -> 1 * numbers[i]).sum();
        if (target < min_sum || target > max_sum) return 0;

        return dfs(numbers, target, idx + 1, sum + numbers[idx]) + dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }
}
