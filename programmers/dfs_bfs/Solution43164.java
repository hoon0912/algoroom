package dfs_bfs;

import java.util.Arrays;

// 단어변환
class Solution43163 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        if (!Arrays.asList(words).contains(target)) return 0;

        boolean[] visited = new boolean[words.length];
        answer = dfs(begin, target, words, visited, 0, words.length + 1, words.length);

        return answer;
    }

    private int dfs(String word, String target, String[] words, boolean[] visited, int count, int minimum, int maximum) {
        for (int i = 0; i < maximum; i++) {
            if (!visited[i] && conversion(word, words[i])) {
                if (words[i].equals(target)) {
                    return Math.min(minimum, count + 1);
                }

                visited[i] = true;
                int num = dfs(words[i], target, words, visited, count + 1, minimum, maximum);
                if (num < minimum) minimum = num;
            }
        }

        return minimum;
    }

    private boolean conversion(String word1, String word2) {
        int count = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
                if (count > 1) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution43163 solution = new Solution43163();

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution.solution(begin, target, words)); // 4

        words = new String[]{"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution.solution(begin, target, words)); // 0

    }
}
