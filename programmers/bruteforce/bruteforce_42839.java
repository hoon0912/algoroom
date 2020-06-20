import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class bruteforce_42839 {
    public static void main(String[] args) {
        String numbers = "011";
        solution(numbers);
    }

    public static int solution(String numbers) {
        List<Character> numList = numbers.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
        Set<String> combinations = combination(numList);
        return (int)combinations.stream()
                .filter(x -> !x.startsWith("0"))
                .mapToInt(Integer::new)
                .filter(x -> {
                    if (x == 1) return false;
                    return !IntStream.rangeClosed(2, (int)Math.sqrt(x)).anyMatch(i -> x % i == 0);
                })
                .count();
    }

    public static Set<String> combination(List<Character> numList) {
        Set<String> result = new HashSet<>();
        int numListSize = numList.size();
        for(int i=0; i<numListSize; i++) {
            char start = numList.get(i);
            numList.remove(i);
            result.add(String.valueOf(start));
            result.addAll(combination(numList).stream()
                    .map(num -> start + num)
                    .collect(Collectors.toSet()));
            numList.add(i, start);
        }
        return result;
    }
}
