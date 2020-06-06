import java.util.*;
class Solution{
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int idx = 0;
        while (stock<k){
            for(; idx<dates.length && dates[idx] <= stock; idx++) pq.add(supplies[idx]);
            stock+=pq.poll();
            answer++;
        }
        return answer;
    }
}