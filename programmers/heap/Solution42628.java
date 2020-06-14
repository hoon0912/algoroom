package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// 이중우선순위큐
public class Solution42628 {

  public int[] solution(String[] operations) {
    int[] answer = new int[2];
    Queue<Integer> minQueue = new PriorityQueue<>();
    Queue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

    for (String s : operations) {
      String[] oper = s.split(" ");
      if ("I".equals(oper[0])) {
        int v = Integer.valueOf(oper[1]);
        maxQueue.offer(v);
        minQueue.offer(v);
      } else if (!maxQueue.isEmpty() && "D".equals(oper[0])) {
        if ("1".equals(oper[1])) {
          int max = maxQueue.poll();
          minQueue.remove(max);
        } else if ("-1".equals(oper[1])) {
          int min = minQueue.poll();
          maxQueue.remove(min);
        }
      }
    }
    if (maxQueue.size() >= 2) {
      answer[0] = maxQueue.poll();
      answer[1] = minQueue.poll();
    }
    return answer;
  }

  public static void main(String[] args) {
    Solution42628 solution = new Solution42628();
    String[] operations = {"I 16", "D 1"}; //[0,0]
    System.out.println("result : " + Arrays.toString(solution.solution(operations)));

    operations = new String[]{"I 7", "I 5", "I -5", "D -1"}; //[7,5]
    System.out.println("result : " + Arrays.toString(solution.solution(operations)));

    operations = new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}; // [0,0]
    System.out.println("result : " + Arrays.toString(solution.solution(operations)));

  }
}
