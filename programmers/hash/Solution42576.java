package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


// 완주하지 못한 선수
public class Solution42576 {

  public String solution(String[] participant, String[] completion) {
    String answer = "";

    Map<String, Integer> map = new HashMap<>();

    for (String p : participant) {
      if (!map.containsKey(p)) {
        map.put(p, 1);
      } else {
        int v = map.get(p);
        map.put(p, v + 1);
      }
    }

    for (String c : completion) {
      int v = map.get(c);
      if (v > 1) {
        map.put(c, v - 1);
      } else {
        map.remove(c);
      }
    }

    answer = map.keySet().iterator().next();

    return answer;
  }

  public String solution2(String[] participant, String[] completion) {
    String answer = "";

    Arrays.sort(participant);
    Arrays.sort(completion);

    for (int i = 0; i < completion.length; i++) {
      if (!completion[i].equals(participant[i])) {
        answer = participant[i];
        break;
      }
    }

    if ("".equals(answer)) {
      answer = participant[participant.length-1];
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution42576 hashSolution = new Solution42576();

    // leo
    String[] participant = {"leo", "kiki", "eden"};
    String[] completion = {"eden", "kiki"};
    System.out.println(hashSolution.solution(participant, completion));

    // vinko
    String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
    String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
    System.out.println(hashSolution.solution(participant2, completion2));

    // mislav
    String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
    String[] completion3 = {"stanko", "ana", "mislav"};
    System.out.println(hashSolution.solution(participant3, completion3));
  }
}
