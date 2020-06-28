package greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// 체육복
public class Solution42862 {
  public int solution(int n, int[] lost, int[] reserve) {
    int answer = n - lost.length;

    Set<Integer> lostSet = new HashSet<>();
    lostSet.addAll(Arrays.stream(lost).boxed().collect(Collectors.toList()));

    Set<Integer> reserveSet = new HashSet<>();
    reserveSet.addAll(Arrays.stream(reserve).boxed().collect(Collectors.toList()));

    // 우선 체크 필요!
    for (int i = 1; i <= n; i++) {
      if (lostSet.contains(i) && reserveSet.contains(i)) {
        lostSet.remove(i);
        reserveSet.remove(i);
        answer++;
      }
    }

    for (int i = 1; i <= n; i++) {
      if (reserveSet.contains(i) && (lostSet.contains(i - 1) || lostSet.contains(i + 1))) {
        reserveSet.remove(i);
        if (lostSet.contains(i - 1)) {
          lostSet.remove(i - 1);
        } else {
          lostSet.remove(i + 1);
        }
        answer++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution42862 solution42862 = new Solution42862();
    int n = 5;
    int[] lost = new int[]{2, 4};
    int[] reserve = new int[]{1, 3, 5};
    int result = solution42862.solution(n, lost, reserve); // 5
    System.out.println("result : " + result + "\n");

    n = 5;
    lost = new int[]{2, 4};
    reserve = new int[]{3};
    result = solution42862.solution(n, lost, reserve); // 4
    System.out.println("result : " + result + "\n");

    n = 3;
    lost = new int[]{3};
    reserve = new int[]{1};
    result = solution42862.solution(n, lost, reserve); // 2
    System.out.println("result : " + result + "\n");

    n = 5;
    lost = new int[]{2, 3, 4};
    reserve = new int[]{3, 4, 5};
    result = solution42862.solution(n, lost, reserve); // 4
    System.out.println("result : " + result + "\n");
  }
}

