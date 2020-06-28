import java.util.Arrays;
import java.util.stream.IntStream;

public class greedy_42862 {
    public static void main(String[] args) {
        int n = 7;
        int[] lost = {2,3,4};
        int[] reserve = {1,2,3,6};
        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        Integer[] clothCount = new Integer[n+1];
        IntStream.rangeClosed(1, n).forEach(i -> clothCount[i] = 1);
        Arrays.stream(lost).forEach(i -> clothCount[i]--);
        Arrays.stream(reserve).forEach(i -> clothCount[i]++);
        Arrays.stream(reserve).filter(i -> clothCount[i] == 2).forEach(i -> {
            if (i > 1 && clothCount[i-1] == 0) { clothCount[i-1]++; clothCount[i]--; }
            else if (i < n && clothCount[i+1] == 0) { clothCount[i+1]++; clothCount[i]--; }
        });

        return n - (int)IntStream.rangeClosed(1,n).filter(i -> clothCount[i] == 0).count();
    }
}
