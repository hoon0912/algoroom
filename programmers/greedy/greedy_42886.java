import java.util.Arrays;

public class greedy_42886 {
    public static void main(String[] args) {
        int[] weight = {3,1,6,2,7,30,1};
        System.out.println(solution(weight));
    }

    public static int solution(int[] weight) {
        Arrays.sort(weight);
        if (weight[0] != 1) return 1;

        int max = 0;
        for(int i=0; i<weight.length; i++) {
            int k = weight[i];
            if (max != 0 && k > max + 1)
                return max + 1;
            else
                max += k;
        }
        return max + 1;
    }
}
