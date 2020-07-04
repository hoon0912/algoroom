import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Map<Integer, Integer> candidate = new HashMap<>();
        Arrays.stream(people).forEach(e->candidate.compute(e, (k,v)-> v == null ? 1 : v+1));
        Arrays.sort(people);
        for(int i = 0; i < people.length; i++){
            int numOnBoard = people[i];
            if(candidate.containsKey(numOnBoard) && candidate.get(numOnBoard) > 0){
                candidate.put(numOnBoard, candidate.get(numOnBoard)-1);
                int target = limit - numOnBoard;
                while (target >= 40 && (!candidate.containsKey(target) || (candidate.containsKey(target) && candidate.get(target)==0))) target--;
                if(target < 40 || (candidate.containsKey(target) && candidate.get(target)==0)){
                    candidate.put(numOnBoard, candidate.get(numOnBoard)+1);
                    break;
                }
                else {
                    candidate.put(target, candidate.get(target)-1);
                    answer++;
                }
            }
        }
        return answer+candidate.values().stream().reduce(Integer::sum).get();
    }
}