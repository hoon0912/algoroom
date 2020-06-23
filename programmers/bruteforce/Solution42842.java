package bruteforce;

import java.util.Arrays;

// 카펫
public class Solution42842 {
  public int[] solution(int brown, int yellow) {
    int[] answer = new int[2];

    int width = brown + yellow;
    for (int n=1; n < width; n++) {
      if (width % n != 0) continue;
      int m = width / n;
      if(m < n) break;
      if (yellow == (m-2)*(n-2)) {
        answer[0] = m;
        answer[1] = n;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution42842 solution = new Solution42842();
    int[] result = solution.solution(10, 2);
    System.out.println(Arrays.toString(result)); // [4,3]

    result = solution.solution(8, 1);
    System.out.println(Arrays.toString(result)); // [3,3]

    result = solution.solution(24, 24);
    System.out.println(Arrays.toString(result)); // [8,6]
  }
}
