package stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// 기능개발
public class Solution42586 {

  class Function {
    private int progress;
    private int speed;

    public Function(int progress, int speed) {
      this.progress = progress;
      this.speed = speed;
    }

    public int getProgress() {
      return progress;
    }

    public int getSpeed() {
      return speed;
    }

    @Override
    public String toString() {
      return "Function{" +
          "progress=" + progress +
          ", speed=" + speed +
          '}';
    }
  }

  public int[] solutionQueue(int[] progresses, int[] speeds) {
    List<Integer> answer = new ArrayList<>();

    Queue<Function> queue = new LinkedList<>();
    for (int i = 0; i < progresses.length; i++) {
      queue.add(new Function(progresses[i], speeds[i]));
    }

    int answerIndex = 0;
    int workDay = 0;
    Function function = null;
    while ((function = queue.peek()) != null) {
      int progress = function.getProgress();
      int speed = function.getSpeed();
      if (workDay == 0) {
        if ((100 - progress) % speed == 0) {
          workDay = (100 - progress) / speed;
        } else {
          workDay = (100 - progress) / speed + 1;
        }
      }

      if (progress + speed * workDay >= 100) {
        if (answer.size() > answerIndex) {
          int v = answer.get(answerIndex);
          answer.set(answerIndex, v + 1);
        } else {
          answer.add(1);
        }
        queue.poll();
      } else {
        workDay=0;
        answerIndex++;
      }
    }

    return answer.stream().mapToInt(Integer::valueOf).toArray();
  }

  public int[] solution(int[] progresses, int[] speeds) {
    List<Integer> answer = new ArrayList<>();

    Stack<Function> stack = new Stack<>();
    for (int i = progresses.length-1; i >= 0; i--) {
      stack.push(new Function(progresses[i], speeds[i]));
    }

    int answerIndex = -1;
    int workDay = 0;
    Function function = null;

    while (!stack.isEmpty() && (function = stack.peek()) != null) {
      int progress = function.getProgress();
      int speed = function.getSpeed();

      if (progress + speed * workDay >= 100) {
        if (answer.size() > answerIndex) {
          int v = answer.get(answerIndex);
          answer.set(answerIndex, v + 1);
        } else {
          answer.add(1);
        }
        stack.pop();
      } else {
        workDay = (100 - progress) / speed;
        if ((100 - progress) % speed != 0) {
          workDay++;
        }
        answerIndex++;
      }
    }

    return answer.stream().mapToInt(Integer::valueOf).toArray();
  }

  public static void main(String[] args) {
    Solution42586 solution = new Solution42586();
    // result = [2,1]
    int[] progresses = new int[]{93, 30, 55};
    int[] speeds = new int[]{1, 30, 5};

    int[] result = solution.solution(progresses, speeds);
    System.out.println(Arrays.toString(result));

  }
}
