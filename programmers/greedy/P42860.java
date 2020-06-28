import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    int minPath = Integer.MAX_VALUE;
    int[] numOfRequiredMoves;
    public int solution(String name) {
        numOfRequiredMoves = IntStream.range(0,name.length()).map(x->Math.min((90-name.charAt(x)+1), (name.charAt(x)-65))).toArray();
        dfs(0, (int)Arrays.stream(numOfRequiredMoves).filter(x->x!=0).count(),0,new int[numOfRequiredMoves.length]);
        return Arrays.stream(numOfRequiredMoves).sum()+minPath-1;
    }

    private void dfs(int step, int check, int now, int[] visited){//step : �����ִ� �Ÿ�, check : �湮�� ��尡 ���ĺ� A�� �ƴ� ���, now : ���� ��ġ
        if(step <= numOfRequiredMoves.length && check == 0)minPath = Math.min(step, minPath);

        else if(step < numOfRequiredMoves.length) {
            if(visited[now] == 0 && numOfRequiredMoves[now] != 0) check--;
            visited[now]++;
            dfs(step + 1, check, now - 1 < 0 ? (numOfRequiredMoves.length - 1) : now - 1,visited);
            dfs(step + 1, check, now + 1 > numOfRequiredMoves.length - 1 ? 0 : now + 1,visited);
            visited[now]--;
        }
    }
}