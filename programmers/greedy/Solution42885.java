package greedy;

import java.util.Arrays;

// 구명보트
public class Solution42885 {

  public int solution(int[] people, int limit) {
    int answer = 0;
    Arrays.sort(people);
    int rightIndex = people.length - 1;
    int leftIndex = 0;

    while ( leftIndex < rightIndex + 1 ) {
      if ( people[leftIndex] + people[rightIndex] <= limit ) {
        leftIndex++;
      }
      rightIndex--;
      answer++;
    }
    return answer;
  }

  public static void main(String[] args) {
    Solution42885 solution = new Solution42885();
    int[] people = new int[]{70, 50, 80, 50};
    int limit = 100;
    System.out.println(solution.solution(people, limit)); // 3

    people = new int[]{70, 80, 50};
    limit = 100;
    System.out.println(solution.solution(people, limit)); // 3
  }
}
