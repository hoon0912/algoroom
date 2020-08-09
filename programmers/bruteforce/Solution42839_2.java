package bruteforce;

import java.util.HashSet;
import java.util.Set;

// 소수찾기
public class Solution42839_2 {

  public int solution(String numbers) {
    char[] list = numbers.toCharArray();
    int[] combArr = new int[list.length];
    for (int i = 0; i < list.length; i++) {
      combArr[i] = Integer.parseInt(String.valueOf(list[i]));
    }

    Set<Integer> prisms = new HashSet<>();
    for (int i = 1; i <= list.length; i++) {
      perm(list, 0, i, prisms);
    }

    System.out.println("소수 리스트입니다.");
    System.out.println(prisms);

    return prisms.size();
  }

  public void perm(char[] arr, int depth, int k, Set prisms) {
    if (depth == k) {
      StringBuilder a = new StringBuilder();
      for (int i = 0; i < k; i++) {
        a.append(arr[i]);
      }
      isPrism(prisms, a);
    } else {
      for (int i = depth; i < arr.length; i++) {
        swap(arr, i, depth);
        perm(arr, depth + 1, k, prisms);
        swap(arr, i, depth);
      }
    }
  }

  public void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private void isPrism(Set prisms, StringBuilder a) {
    int b = Integer.parseInt(String.valueOf(a));

    boolean isPrism = true;
    if (b <= 1) {
      return;
    }
    for (int j = 2; j <= Math.sqrt(b); j++) {
      if (b % j == 0) {
        isPrism = false;
        break;
      }
    }
    if (isPrism) {
      prisms.add(b);
    }
  }


  public static void main(String[] args) {
    Solution42839_2 solution = new Solution42839_2();
    System.out.println(solution.solution("17")); // 3
    System.out.println(solution.solution("011")); // 2
    System.out.println(solution.solution("1234")); // 2
  }
}
