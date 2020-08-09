package dfs_bfs;

import java.util.Arrays;

// 단어변환
class Solution43163 {
    private boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        int wordLength = words.length;
        if (!Arrays.asList(words).contains(target)) return 0;

        visited = new boolean[wordLength];
        answer = dfs(begin, target, words, 0, Integer.MAX_VALUE, wordLength);

        return answer;
    }

    private int dfs(String word, String target, String[] words, int count, int minimum, int wordLength) {
        for (int i = 0; i < wordLength; i++) {
            if (!visited[i] && convertible(word, words[i])) {
                if (words[i].equals(target)) {
                    return Math.min(minimum, count + 1);
                }

                visited[i] = true;
                int num = dfs(words[i], target, words, count + 1, minimum, wordLength);
                if (num < minimum) minimum = num;
                visited[i] = false;
            }
        }

        return minimum;
    }

    private boolean convertible(String word1, String word2) {
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
