package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// 라면공장
public class Solution42629 {
  public int solution(int stock, int[] dates, int[] supplies, int k) {
    int answer = 0;
    Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    for (int day = 0, dateIndex = 0; day < k; day++) {
      if (dateIndex < dates.length && day == dates[dateIndex]) {
        queue.offer(supplies[dateIndex]);
        dateIndex++;
      }

      if (stock == 0) {
        stock += queue.poll();
        answer++;
      }

      stock--;
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution42629 solution42629 = new Solution42629();

    // 2
    int stock = 4;
    int[] dates = {4, 10, 15};
    int[] supplies = {20, 5, 10};
    int k = 30;

    System.out.println(solution42629.solution(stock, dates, supplies, k));
  }
}
