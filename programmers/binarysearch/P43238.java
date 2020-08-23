import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        long answer = (long) n * Arrays.stream(times).max().getAsInt();
        long left = 1, right = answer;
        while (left<=right){
            long mid = (left+right)/2;
            long total = Arrays.stream(times).mapToLong(x->mid/x).sum();
            if(total < n) left = mid+1;
            else {
                if(answer > mid) answer = mid;
                right = mid-1;
            }
        }
        return answer;
    }
}