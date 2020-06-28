import java.util.stream.IntStream;

public class greedy_42883 {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
        System.out.println(solution(number, k));
    }

    public static String solution(String number, int k) {
        String answer = "";
        int needsToPick = number.length() - k;
        while (needsToPick > 0) {
            int numberLength = number.length();
            int from = 0;
            int to = numberLength - needsToPick;

            char maxDigit = (char) number.substring(from, to + 1).chars().max().getAsInt();
            int maxDigitIdx = number.indexOf(maxDigit);

            if (from == to) {
                answer += number;
                break;
            }

            answer += maxDigit;
            number = number.substring(maxDigitIdx + 1);
            needsToPick--;
        }
        return answer;
    }
}
