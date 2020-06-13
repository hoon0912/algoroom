import java.util.Arrays;

public class sort_42747 {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        int result = solution(citations);
        System.out.println(result);
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int length = citations.length;
        for(int i=0; i < length; i++) {
            int productivity = length - i;
            int influence = citations[i];

            if (influence >= productivity) {
                answer = productivity;
                break;
            }
        }
        return answer;
    }
}
