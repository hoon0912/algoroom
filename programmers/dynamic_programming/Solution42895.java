package dynamic_programming;

// N으로 표현
public class Solution42895 {
  private int answer = Integer.MAX_VALUE;
  private int N;
  private int number;
  public int solution(int N, int number) {
    this.N = N;
    this.number = number;
    dfs( 0, 0);
    if (answer > 8) answer = -1;
    return answer;
  }

  private void dfs(int count, int makeNumber) {
    if (count > 8) return;
    if (makeNumber == number) {
      answer = Math.min(count, answer);
      return;
    }

    int tmp = 0;
    for (int i = 1; i <= 8; i++) {
      tmp = tmp * 10 + N;
      dfs(count + i, makeNumber + tmp);
      dfs(count + i, makeNumber * tmp);
      dfs(count + i, makeNumber - tmp);
      if (tmp != 0) dfs(count + i, makeNumber / tmp);
    }
  }

  public static void main(String[] args) {
    Solution42895 solution = new Solution42895();
    System.out.println(solution.solution(5, 12)); // 4
    System.out.println(solution.solution(2, 11)); // 3
  }
}
