package hash;

import java.util.HashMap;
import java.util.Map;

// 위장
public class Solution42578 {
  public int solution(String[][] clothes) {
    int answer = 1;

    Map<String, Integer> map = new HashMap<>();

    for (String[] clothe : clothes) {
      map.put(clothe[1], map.getOrDefault(clothe[1], 0)+1);
    }

    for (int count : map.values()) {
      answer *= (count + 1);
    }

    return answer - 1;
  }

  public static void main(String[] args) {
    Solution42578 solution42578 = new Solution42578();

    String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
    System.out.println(solution42578.solution(clothes)); // 5

    clothes = new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}; // 3
    System.out.println(solution42578.solution(clothes));  // 3
  }
}
