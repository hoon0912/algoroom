import java.util.*;
import java.util.stream.IntStream;
class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Deque<Integer> deque = new LinkedList<>(); deque.add(1);
            IntStream.range(0, progresses.length).map(x->
                    (100 - progresses[x])/speeds[x] + ((100 - progresses[x])%speeds[x] != 0 ? 1 : 0)
            ).reduce((x,y)->{
                deque.addLast((x>=y) ? deque.pollLast()+1 : 1);
                return Math.max(x,y);
            });
            return deque.stream().mapToInt(Integer::intValue).toArray();
        }
}