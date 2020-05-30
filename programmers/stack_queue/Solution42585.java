package stack_queue;

import java.util.Stack;

// 쇠막대기
public class Solution42585 {

  public int solution(String arrangement) {
    int answer = 0;
    Stack<Character> stack = new Stack<>();

    char pre = 0;
    for (int i = 0; i < arrangement.length(); i++) {
      char cur = arrangement.charAt(i);

      if (cur == '(') {
        stack.push(cur);
      } else if (cur == ')') {
        stack.pop();
        if (pre == '(') {
          answer += stack.size();
        } else {
          answer++;
        }
      }
      pre = cur;
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution42585 solution42585 = new Solution42585();

    // 17
    String arrangement = "()(((()())(())()))(())";
    System.out.println(solution42585.solution(arrangement));
  }
}
