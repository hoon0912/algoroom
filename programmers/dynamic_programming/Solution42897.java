package dynamic_programming;

// 도둑질
public class Solution42897 {
  public int solution(int[] money) {
    int length = money.length;
    int[] dpStep1 = new int[length];
    int[] dpStep2 = new int[length];

    dpStep1[0] = money[0];
    dpStep1[1] = money[0];

    dpStep2[0] = 0;
    dpStep2[1] = money[1];

    for (int i = 2; i < length - 1; i++)
      dpStep1[i] = Math.max(dpStep1[i - 2] + money[i], dpStep1[i - 1]);

    for (int i = 2; i < length; i++)
      dpStep2[i] = Math.max(dpStep2[i - 2] + money[i], dpStep2[i - 1]);

    return Math.max(dpStep1[length - 2], dpStep2[length - 1]);
  }

  public static void main(String[] args) {
    Solution42897 solution = new Solution42897();
    int[] money = new int[]{1, 2, 3, 1};
    System.out.println(solution.solution(money)); // 1
  }
}
