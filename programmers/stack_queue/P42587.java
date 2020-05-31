import java.util.*;
import java.util.stream.IntStream;
class Solution {
           class PrintJob{
               int location;
               int priority;
               PrintJob(int location, int priority){
                   this.location = location;
                   this.priority = priority;
               }
           }
        public int solution(int[] priorities, int location) {
           int answer = 0;
            int myPriority = priorities[location];
            int maxPriority = Arrays.stream(priorities).max().getAsInt();
            Deque<PrintJob> queue = new ArrayDeque<>(priorities.length);
            IntStream.range(0,priorities.length).forEach(i->queue.add(new PrintJob(i, priorities[i])));
            for(int i = maxPriority; i>=myPriority; i--){
                int target = i;
                int numTarget = Arrays.stream(priorities).map(x->(x == target) ? 1 : 0).sum();
                for(;numTarget != 0;){
                    PrintJob now = queue.poll();
                    if(now.priority != target) queue.addLast(now);
                    else {
                        numTarget--;
                        answer++;
                    }
                    if(target == myPriority && now.location == location) break;
                }
            }
            return answer;
        }
    }