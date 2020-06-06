package heap;

import java.util.PriorityQueue;
import java.util.Queue;

// 더맵게
public class Solution42626 {
  public int solution(int[] scoville, int K) {
    int answer = 0;

    Queue<Integer> queue = new PriorityQueue<>();
    for (int s : scoville) {
      queue.offer(s);
    }

    while (!queue.isEmpty()) {
      int f1 = queue.poll();
      if (f1 >= K) break;

      if (!queue.isEmpty()) {
        int f2 = queue.poll();
        queue.offer(f1 + f2 * 2);
        answer++;
      } else {
        return -1;
      }

    }

    return answer;
  }

  public static void main(String[] args) {
    Solution42626 solution42626 = new Solution42626();
    // 2
    int[] scoville = {1, 2, 3, 9, 10, 12};
    int K = 7;

    System.out.println("result : " + solution42626.solution(scoville, K));
  }
}
