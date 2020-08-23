package binarysearch;

import java.util.Arrays;

// 징검다리
public class Solution43236 {
  public int solution(int distance, int[] rocks, int n) {
    Arrays.sort(rocks);

    int answer = 0;
    int left = 1;
    int right = distance;
    int mid = 0;

    while (left <= right) {
      int removeRock = 0;
      int lastRock = 0;

      mid = (left + right) / 2;
      for (int i = 0; i < rocks.length; i++) {
        if (rocks[i] - lastRock < mid ) {
          removeRock++;
        } else {
          lastRock = rocks[i];
        }
      }

      if (distance - lastRock < mid ) {
        removeRock++;
      }

      if (removeRock <= n) {
        answer = mid > answer ? mid : answer;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution43236 solution = new Solution43236();
    int distance = 25;
    int[] rocks = new int[]{2, 14, 11, 21, 17};
    int n  = 2;
    System.out.println(solution.solution(distance, rocks, n));  // 4
  }
}
