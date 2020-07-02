import java.util.Arrays;

public class greedy_42885 {
    public static void main(String[] args) {
        int[] people = {70,80,50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int min_idx = 0;
        int max_idx = people.length - 1;
        while (min_idx <= max_idx) {
            if (people[min_idx] + people[max_idx] <= limit) {  // 2명씩(min,max) 타는 경우
                min_idx++;
                max_idx--;
            }
            else {   // max 혼자 타는 경우
                max_idx--;
            }
            answer++;
        }
        return answer;
    }
}
