package binarysearch;

import java.util.Arrays;

// 입국심사
public class Solution43238 {
  public long solution(int n, int[] times) {
    Arrays.sort(times);

    long answer = 0;
    long left = 1;
    long right = (long)times[times.length - 1] * n;
    long mid = 0;

    while(left <= right) {
      long count = 0;
      mid = (left + right) / 2;

      for (int time : times){
        count += (long) mid / time;
      }

      if (count >= n) {
        right = mid - 1;
        answer = mid;
      } else {
        left = mid + 1;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution43238 solution = new Solution43238();
    int n = 6;
    int[] times = new int[]{7, 10};
    System.out.println(solution.solution(n, times));  // 28
  }
}
