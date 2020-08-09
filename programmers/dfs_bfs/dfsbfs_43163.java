
import java.util.*;

public class dfsbfs_43163 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        HashMap<String, List<Integer>> inverted_index = new HashMap<>();
        for(int i=0 ; i<words.length; i++) {
            index(inverted_index, words[i], i);
        }

        Queue<Pair<Integer, String>> q = new LinkedList<>();
        q.add(new Pair<>(0, begin));
        while (!q.isEmpty()) {
            Pair<Integer, String> pair = q.poll();
            Integer depth = pair.getDepth();
            String word = pair.getWord();

            if(word.equals(target)) {
                return depth;
            }

            List<Integer> match_ids = search(inverted_index, word);
            match_ids.stream().filter(x -> !visited[x]).distinct().forEach(x -> { visited[x] = true; q.add(new Pair<>(depth + 1, words[x])); } );
        }
        return 0;
    }

    public static void index(HashMap<String, List<Integer>> inverted_index, String word, int word_idx) {
        char[] word_chars = word.toCharArray();
        for(int k=0; k<word.length(); k++) {
            char original_char = word_chars[k];
            word_chars[k] = '.';
            String temp = String.valueOf(word_chars);
            inverted_index.computeIfAbsent(temp, x -> new ArrayList<>()).add(word_idx);
            word_chars[k] = original_char;
        }
    }

    public static List<Integer> search(HashMap<String, List<Integer>> inverted_index, String word) {
        List<Integer> match_ids = new ArrayList<>();
        char[] word_chars = word.toCharArray();
        for(int k=0; k<word.length(); k++) {
            char original_char = word_chars[k];
            word_chars[k] = '.';
            String temp = String.valueOf(word_chars);
            if (inverted_index.containsKey(temp)) {
                match_ids.addAll(inverted_index.get(temp));
            }
            word_chars[k] = original_char;
        }
        return match_ids;
    }

    public static class Pair<I extends Number, S> {
        final Integer depth;
        final String word;

        public Pair(Integer depth, String word) {
            this.depth = depth;
            this.word = word;
        }

        public Integer getDepth() {
            return depth;
        }

        public String getWord() {
            return word;
        }
    }
}
