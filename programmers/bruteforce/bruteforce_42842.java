import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class bruteforce_42842 {
    public static void main(String[] args) {
        int[] result = solution(24, 24);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        List<carpet> candidates = IntStream.rangeClosed(2, total/2).filter(height -> total % height == 0).mapToObj(height -> new carpet(total/height, height)).collect(Collectors.toList());
        for(carpet candidate : candidates) {
            int width = candidate.getWidth();
            int height = candidate.getHeight();

            boolean isPossible = IntStream.range(1, height).anyMatch(margin -> width * 2*margin + (height - 2*margin)*2 == brown);
            if (isPossible) return IntStream.of(width, height).toArray();
        }
        return null;
    }

    public static class carpet {
        private int width;
        private int height;

        public carpet(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }
    }
}
