package greedy;

import java.util.Arrays;

// 저울
public class Solution42886 {

  public int solution(int[] weight) {
    int answer = 1;
    Arrays.sort(weight);
    System.out.println(Arrays.toString(weight));
    for (int i = 0; i < weight.length; i++) {
      if (answer < weight[i]) {
        break;
      }
      answer += weight[i];
    }

    return answer;
  }

//  int w = weight[i];
//      if(answer >= w) {
//    answer += w;
//  }
//      else break;

  public static void main(String[] args) {
    Solution42886 solution = new Solution42886();
    int[] weight = new int[]{3, 1, 6, 2, 7, 30, 1};
    System.out.println(solution.solution(weight)); // 21
  }
}
