package stack_queue;

import java.util.Stack;

// 탑
public class Solution42588 {

  static class Top {
    int heights;
    int number;

    public Top(int heights, int number) {
      this.heights = heights;
      this.number = number;
    }

    public int getHeights() {
      return heights;
    }

    public int getNumber() {
      return number;
    }
  }

  public int[] solution(int[] heights) {
    int[] answer = new int[heights.length];

    Stack<Top> stack = new Stack<>();
    for (int i = heights.length - 1; i >= 1; i--) {
      if (heights[i] < heights[i-1]) {
        answer[i] = i;

        while(!stack.isEmpty()) {
          Top top = stack.pop();
          if (top.getHeights() < heights[i-1]) {
            answer[top.getNumber() - 1] = i;
          }
        }
      } else {
        stack.push(new Top(heights[i], i+1));
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution42588 solution42588 = new Solution42588();
    int[] answer = {};
    int[] heights = {6,9,5,7,4}; // [0,0,2,2,4]
    answer = solution42588.solution(heights);
    print(answer);

    heights = new int[]{3,9,9,3,5,7,2}; // [0,0,0,3,3,3,6]
    answer = solution42588.solution(heights);
    print(answer);

    heights = new int[]{1,5,3,6,7,6,5}; // [0,0,2,0,0,5,6]
    answer = solution42588.solution(heights);
    print(answer);

    heights = new int[]{5,4,3,2,1}; // [0,0,0,3,3,3,6]
    answer = solution42588.solution(heights);
    print(answer);
  }

  public static void print(int[] answer) {
    System.out.print("[ ");
    for (int i = 0; i < answer.length; i++) {
      System.out.print(answer[i]);
      if (i < answer.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println(" ]");
  }
}
