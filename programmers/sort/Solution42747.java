package sort;

import java.util.Arrays;

// H-index
public class Solution42747 {
  public int solution(int[] citations) {
    int answer = 0;
    Arrays.sort(citations);
    int length = citations.length;
    for (int i = 0; i < length; i++) {
      int citation = citations[i];
      int count = length - i;
      if (count <= citation) {
        answer = count;
        break;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Solution42747 solution = new Solution42747();

    // 3
    int[] numbers = {3, 0, 6, 1, 5};
    int answer = solution.solution(numbers);
    System.out.println("### result : " + answer);
  }
}
