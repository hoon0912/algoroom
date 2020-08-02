package dynamic_programming;

// 서울에서 경산까지
public class Solution42899 {
  public int solution(int K, int[][] travel) {
    int answer = 0;
    int[][] dp = new int[travel.length][K + 1];

    dp[0][travel[0][0]] = travel[0][1];
    dp[0][travel[0][2]] = travel[0][3];

    for (int i = 1; i < travel.length; i++) {
      for (int j = 0; j <= K; j++) {
        if (dp[i-1][j] == 0) {
          continue;
        }

        if (j + travel[i][0] <= K) {
          dp[i][j + travel[i][0]] = Math.max(dp[i][j + travel[i][0]], dp[i-1][j] + travel[i][1]);
          answer = Math.max(answer, dp[i][j + travel[i][0]]);
        }

        if (j + travel[i][2] <= K) {
          dp[i][j + travel[i][2]] = Math.max(dp[i][j + travel[i][2]], dp[i-1][j] + travel[i][3]);
          answer = Math.max(answer, dp[i][j + travel[i][2]]);
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution42899 solution = new Solution42899();
    int K = 1650;
    int[][] travel = new int[][] {{500, 200, 200, 100}, {800, 370, 300, 120}, {700, 250, 300, 90}};
    System.out.println(solution.solution(K,  travel)); // 660

    K = 3000;
    travel = new int[][] {{000, 2000, 300, 700}, {1100, 1900, 400, 900}, {900, 1800, 400, 700}, {1200, 2300, 500, 1200}};
    System.out.println(solution.solution(K,  travel)); // 5900

  }
}
