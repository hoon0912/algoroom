import java.util.stream.IntStream;

class Solution {
    private String target;
    private String[] words;
    private int minCount = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        dfs(begin,0, new boolean[words.length]);
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }

    private void dfs(String nowWord, int step, boolean[] isCheck) {
        if(target.equals(nowWord)) minCount = Math.min(minCount, step);
        for(int i = 0, limit = words.length; i<limit; i++){
            if(!isCheck[i] && isAbleWord(nowWord, words[i])){
                isCheck[i] = true;
                dfs(words[i], step+1, isCheck);
                isCheck[i] = false;
            }
        }
    }

    private boolean isAbleWord(String x, String y){
        return (x.length()-1) == IntStream.range(0,x.length()).filter(idx->x.charAt(idx)==y.charAt(idx)).count();
    }
}