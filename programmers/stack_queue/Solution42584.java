package stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 주식가격
public class Solution42584 {

  public int[] solution(int[] prices) {
    int[] answer = new int[prices.length];

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < prices.length; i++) {
      queue.offer(prices[i]);
    }

    int index = 0;
    while (!queue.isEmpty()) {
      int curPrice = queue.poll();
      int time = 0;
      for (int i = index + 1; i < prices.length; i++) {
        time++;
        if (curPrice > prices[i]) {
          break;
        }
      }
      answer[index] = time;
      index++;
    }

    return answer;
  }

  public int[] solution2(int[] prices) {
    int[] answer = new int[prices.length];

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < prices.length; i++) {
      queue.offer(prices[i]);
    }

    int index = 0;
    while (!queue.isEmpty()) {
      int curPrice = queue.poll();
      int time = (int) queue.stream().filter(p -> (curPrice <= p)).count();
      answer[index] = time;
      index++;
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution42584 solution42584 = new Solution42584();

    // [4, 3, 1, 1, 0]
    long startTime = System.currentTimeMillis();
    int[] prices = new int[]{1, 2, 3, 2, 3};
    int[] answer = solution42584.solution(prices);
    long endTime = System.currentTimeMillis();
    System.out.println(Arrays.toString(answer));
    //System.out.println((endTime-startTime)+" ms");

    // [5, 1, 1, 1, 1, 0]
    prices = new int[]{1, 4, 3, 2, 1, 4};
    answer = solution42584.solution(prices);
    System.out.println(Arrays.toString(answer));

    // [0,0,0,0,0]
    prices = new int[]{1, 2, 3, 4, 5};
    answer = solution42584.solution(prices);
    System.out.println(Arrays.toString(answer));
  }
}
