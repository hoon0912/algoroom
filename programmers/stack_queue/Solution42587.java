package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

// 프린터
public class Solution42587 {
  static class Document {
    private int priority;
    private int index;

    public Document(int priority, int index) {
      this.priority = priority;
      this.index = index;
    }

    public int getPriority() {
      return priority;
    }

    public int getIndex() {
      return index;
    }
  }

  public int solution(int[] priorities, int location) {
    int answer = 0;
    Queue<Document> queue = new LinkedList<>();

    for (int i = 0; i < priorities.length; i++) {
      queue.add(new Document(priorities[i], i));
    }

    while (!queue.isEmpty()) {
      Document document = queue.poll();
      int count = (int) queue.stream().filter(p -> (document.getPriority() < p.getPriority())).count();

      if (count > 0) {
        queue.add(document);
      } else if (count == 0 && document.getPriority() >= priorities[location]) {
        answer++;
        if (document.getIndex() == location)
          break;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution42587 solution42587 = new Solution42587();
    // 1
    int[] priorities = new int[]{2, 1, 3, 2};
    int location = 2;
    System.out.println(solution42587.solution(priorities, location));

    // 5
    priorities = new int[]{1, 1, 9, 1, 1, 1};
    location = 0;
    System.out.println(solution42587.solution(priorities, location));
  }
}
