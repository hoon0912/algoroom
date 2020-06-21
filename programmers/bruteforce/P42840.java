import java.util.Arrays;
import java.util.stream.IntStream;
class Solution {
    public int[] solution(int[] answers) {
        int[] checkCount = Arrays.stream(new int[][]{{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}}).mapToInt(x->IntStream.range(0, answers.length).map(y->answers[y] == x[y%x.length] ? 1: 0).sum()).toArray();
        int maxCount = Arrays.stream(checkCount).max().getAsInt();
        return IntStream.range(1,4).filter(x->checkCount[x-1] == maxCount).toArray();
    }
}