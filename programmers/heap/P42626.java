import java.util.*;
class Solution{
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        public int solution(int[] scoville, int K) {
            int answer = 0;
            for(int x : scoville) pq.add(x);
            while (pq.peek() < K && pq.size() != 1) answer += pq.add(pq.poll() + pq.poll() * 2) ? 1:0;
            return pq.peek() < K ? -1 : answer;
        }
}