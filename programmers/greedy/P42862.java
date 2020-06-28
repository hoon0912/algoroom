import java.util.Arrays;
import java.util.stream.IntStream;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] status = IntStream.range(0,n).map(x->1).toArray();
        Arrays.stream(reserve).forEach(x->status[x-1]++);
        Arrays.stream(lost).forEach(x->status[x-1]--);
        for(int i = 0; i<n; i++){
            if(status[i] == 0){//ü������ ��������
                if(i-1 >=0 && status[i-1] == 2) status[i] = --status[i-1];//�տ� �л��� ü������ �ִ°�?
                else if(i+1<n && status[i+1] == 2) status[i] = --status[i+1];//�ڿ� �л��� ü������ �ִ°�?
            }
        }
        return (int)Arrays.stream(status).filter(x->x!=0).count();
    }
}