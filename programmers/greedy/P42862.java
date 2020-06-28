import java.util.Arrays;
import java.util.stream.IntStream;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] status = IntStream.range(0,n).map(x->1).toArray();
        Arrays.stream(reserve).forEach(x->status[x-1]++);
        Arrays.stream(lost).forEach(x->status[x-1]--);
        for(int i = 0; i<n; i++){
            if(status[i] == 0){//체육복을 빌려야함
                if(i-1 >=0 && status[i-1] == 2) status[i] = --status[i-1];//앞에 학생이 체육복이 있는가?
                else if(i+1<n && status[i+1] == 2) status[i] = --status[i+1];//뒤에 학생이 체육복이 있는가?
            }
        }
        return (int)Arrays.stream(status).filter(x->x!=0).count();
    }
}