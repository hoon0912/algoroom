package dynamic_programming;

// 타일 장식물
public class Solution43104 {
  public long solution(int N) {
    long[] tileLength = new long[N+1];
    tileLength[1] = 1;
    tileLength[2] = 1;

    for (int i = 3; i <= N; i++) {
      tileLength[i] = tileLength[i - 1] + tileLength[i - 2];
    }

    return tileLength[N] * 4 + tileLength[N - 1] * 2;
  }

  public static void main(String[] args) {
    Solution43104 solution = new Solution43104();
    System.out.println(solution.solution(5)); // 26
    System.out.println(solution.solution(6)); // 42
  }
}
