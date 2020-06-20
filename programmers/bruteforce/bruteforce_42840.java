import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class bruteforce_42840 {
    public static void main(String[] args) {
        int[] answer = {1,3,2,4,2};
        int[] result = solution(answer);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] solution(int[] answers) {
        int[] pattern_one = {1, 2, 3, 4, 5};
        int[] pattern_two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern_three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        long person_one = IntStream.range(0, answers.length).filter(i -> answers[i] == pattern_one[i % pattern_one.length]).count();
        long person_two = IntStream.range(0, answers.length).filter(i -> answers[i] == pattern_two[i % pattern_two.length]).count();
        long person_three = IntStream.range(0, answers.length).filter(i -> answers[i] == pattern_three[i % pattern_three.length]).count();

        List<Long> score = Arrays.asList(person_one, person_two, person_three);
        Long maxScore = score.stream().max(Long::compare).get();
        return IntStream.range(1, 4).filter(i -> score.get(i-1).equals(maxScore)).sorted().toArray();
    }
}
