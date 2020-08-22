
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class binarysearch_43236 {
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        System.out.println(solution(distance,rocks,n));
    }

    public static int solution(int distance, int[] rocks, int n) { // success
        int answer = 0;
        int start = 0;
        int end = distance;

        ArrayList<Integer> rockList = (ArrayList) Arrays.stream(rocks).sorted().boxed().collect(Collectors.toList());
        rockList.add(0, 0);
        rockList.add(rockList.size(), distance);
        while (start <= end) {
            int mid = (start + end) / 2;
            int deleted_n = getDeleteCount(rockList, mid);

            if (deleted_n > n) {
                end = mid - 1;
            }
            else if (deleted_n <= n){
                start = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        return answer;
    }

    public static int getDeleteCount(ArrayList<Integer> rockList, int mid) {
        int count = 0;
        int current_pos = 0;
        for(int i=1; i<rockList.size(); i++) {
            if (rockList.get(i) - current_pos < mid) count++;
            else current_pos = rockList.get(i);
        }
        return count;
    }

    /*public static int solution1(int distance, int[] rocks, int n) {  // fail
        int answer = 0;
        ArrayList<Integer> rockList = (ArrayList) Arrays.stream(rocks).sorted().boxed().collect(Collectors.toList());
        rockList.add(0, 0);
        rockList.add(rockList.size(), distance);

        PriorityQueue<RockInfo> pq = new PriorityQueue<>();
        for(int i=0; i<rockList.size()-1; i++) {
            pq.add(new RockInfo((long)rockList.get(i+1) - rockList.get(i), i, i+1));
        }

        int deleted_cnt = 0;
        boolean[] deleted = new boolean[rockList.size()];
        while (deleted_cnt <= n && !pq.isEmpty()) {
            RockInfo info = pq.poll();
            long dist = info.getDistance();
            int start_rock = info.getStart();
            int end_rock = info.getEnd();

            if (deleted[start_rock] || deleted[end_rock]) continue;

            if (deleted_cnt < n) {
                int delete_rock = getDeleteRock(start_rock, end_rock, rockList, deleted);
                long next_dist = 0;
                if (delete_rock == end_rock) {
                    while (end_rock < rockList.size()) { end_rock++; if (!deleted[end_rock]) break; }
                    next_dist = rockList.get(end_rock) - rockList.get(delete_rock);
                }
                else if (delete_rock == start_rock) {
                    while(start_rock >= 0) { start_rock--; if (!deleted[start_rock]) break; }
                    next_dist = rockList.get(delete_rock) - rockList.get(start_rock);
                }

                deleted[delete_rock] = true;
                deleted_cnt++;
                pq.add(new RockInfo(dist + next_dist, start_rock, end_rock));
            }
            else if (deleted_cnt == n){
                return (int)dist;
            }
        }
        return answer;
    }

    public static int getDeleteRock(int start_rock, int end_rock, ArrayList<Integer> rockList, boolean[] deleted) {
        if (start_rock -1 < 0) return end_rock;
        if (end_rock + 1 > rockList.size() - 1) return start_rock;

        int start_sum = 0;
        for(int k=start_rock; k > 0; k--) {
            start_sum += (rockList.get(k) - rockList.get(k-1));
            if (!deleted[k-1]) break;
        }
        int end_sum = 0;
        for(int k=end_rock; k < rockList.size() - 1; k++) {
            end_sum += (rockList.get(k+1) - rockList.get(k));
            if (!deleted[k+1]) break;
        }

        if (start_sum >= end_sum) return end_rock;
        else return start_rock;
    }

    public static class RockInfo implements Comparable<RockInfo>{
        private final long distance;
        private final int start_rock;
        private final int end_rock;

        public RockInfo(long distance, int start_rock, int end_rock) {
            this.distance = distance;
            this.start_rock = start_rock;
            this.end_rock = end_rock;
        }

        public long getDistance() {
            return distance;
        }

        public int getStart() {
            return start_rock;
        }

        public int getEnd() {
            return end_rock;
        }

        @Override
        public int compareTo(RockInfo o) {
            return this.distance <= o.distance ? -1 : 1;
        }
    }*/
}
