package bruteforce;

import java.util.HashSet;
import java.util.Set;

// 숫자야구게임
public class Solution42841 {
  public int solution(int[][] baseball) {
    int answer;

    Set<String> answerList = new HashSet<>();
    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        if (i == j)
          continue;
        for (int k = 1; k <= 9; k++) {
          if (j == k || i == k)
            continue;
          answerList.add(i + "" + j + "" + k);
        }
      }
    }

    answer = (int) answerList.stream().filter(number -> check(number, baseball)).count();

    return answer;
  }

  private boolean check(String number, int[][] baseball) {
    boolean checkFlag = true;
    for (int i = 0; i < baseball.length; i++) {
      int strike = 0;
      int ball = 0;
      String targetNumber = baseball[i][0] + "";

      for (int a = 0; a < 3; a++) {
        for (int b = 0; b < 3; b++) {
          if (number.charAt(a) != targetNumber.charAt(b)) continue;

          if (a == b) {
            strike++;
          } else {
            ball++;
          }

        }
      }
      if (strike != baseball[i][1] || ball != baseball[i][2]) {
        checkFlag = false;
        break;
      }
    }
    return checkFlag;
  }

  public static void main(String[] args) {
    Solution42841 solution = new Solution42841();
    int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
    System.out.println(solution.solution(baseball)); // 2
  }
}
