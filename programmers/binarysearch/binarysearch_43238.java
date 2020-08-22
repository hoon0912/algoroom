import java.util.Arrays;

public class binarysearch_43238 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {4,10};
        System.out.println(solution(n, times));
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        long start = 0;
        long end = Arrays.stream(times).asLongStream().max().getAsLong() * n;

        while (start <= end) {
            long mid = (start + end) / 2;
            long passed_n = Arrays.stream(times).asLongStream().map(t -> (mid / t)).sum();

            if (passed_n >= n) {
                answer = mid;
                end = mid - 1;
            }
            else if (passed_n < n) {
                start = mid + 1;
            }
        }
        return answer;
    }
}
