import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
class Solution {
    class Job implements Comparable<Job> {
        int start, duration;
        Job(int[] jobInfo){
            this.start = jobInfo[0];
            this.duration = jobInfo[1];
        }
        @Override
        public int compareTo(Job o) {
            return this.duration == o.duration ? this.start-o.start : this.duration - o.duration;
        }
    }

    public int solution(int[][] jobs) {
        PriorityQueue<Job> scheduler = new PriorityQueue<>();
        IntStream.range(0,jobs.length).forEach(x->scheduler.add(new Job(jobs[x])));
        int time = 0;
        int answer = 0;
        while (!scheduler.isEmpty()){
            ArrayList<Job> disableJobs = new ArrayList<>();
            while(!scheduler.isEmpty() && time < scheduler.peek().start) disableJobs.add(scheduler.poll());
            if(scheduler.isEmpty()){
                time++;
            }else{
                Job now = scheduler.poll();
                answer += time - now.start + now.duration;
                time += now.duration;
            }
            scheduler.addAll(disableJobs);
        }
        return answer/jobs.length;
    }
}