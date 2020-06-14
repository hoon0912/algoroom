import java.util.Arrays;
import java.util.stream.Collectors;
class Solution {
    public String solution(int[] numbers) {
        if(Arrays.stream(numbers).filter(x->x > 0).toArray().length == 0) return "0";
        return Arrays.stream(numbers).mapToObj(String::valueOf).sorted((o1, o2) -> -o1.concat(o2).compareTo(o2.concat(o1))).collect(Collectors.joining());
    }
}