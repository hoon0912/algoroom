import java.util.Arrays;
import java.util.stream.IntStream;
class Solution {
    public int solution(int[] citations) {
        return IntStream.range(0,citations.length+1).filter(x->x<=Arrays.stream(citations).filter(y->x<=y).toArray().length).max().getAsInt();
    }
}