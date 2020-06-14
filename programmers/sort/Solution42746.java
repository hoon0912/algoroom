package sort;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// 가장큰수
public class Solution42746 {
  public String solution(int[] numbers) {
    StringBuilder stringBuilder = new StringBuilder();
    List<String> list = new LinkedList<>();

    for (int i = numbers.length - 1; i >= 0; i--) {
      list.add(String.valueOf(numbers[i]));
    }
    Collections.sort(list, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

    if ("0".equals(list.get(0))) {
      return "0";
    }

    for (String s : list) {
      stringBuilder.append(s);
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    Solution42746 solution = new Solution42746();

    // 6210
    int[] numbers = {6, 10, 2};
    String answer = solution.solution(numbers);
    System.out.println("### result : " + answer);

    // 9534330
    numbers = new int[]{3, 30, 34, 5, 9};
    answer = solution.solution(numbers);
    System.out.println("### result : " + answer);

    // 0
    numbers = new int[]{0, 0};
    answer = solution.solution(numbers);
    System.out.println("### result : " + answer);
  }
}
