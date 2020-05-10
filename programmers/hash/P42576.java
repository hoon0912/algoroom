import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> bucket = new HashMap<>();
        Arrays.stream(participant).forEach(e->bucket.compute(e, (k,v)-> v == null ? 1 : v+1));
        Arrays.stream(completion).forEach(e->bucket.computeIfPresent(e,(k,v)->v-1));
        bucket.values().removeAll(Collections.singleton(0));
        return bucket.keySet().stream().findFirst().orElse("ERROR");
    }
}