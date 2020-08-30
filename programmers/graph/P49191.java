import java.util.Arrays;
class Solution {
    public int solution(int n, int[][] results) {
        int[][] map = new int[n+1][n+1];
        //½Â¸® 1, ÆĞ¹è -1
        Arrays.stream(results).forEach(x->{
            map[x[0]][x[1]] = 1;
            map[x[1]][x[0]] = -1;
        });

        for(int mid = 1; mid<=n; mid++){
            for(int src = 1; src<=n; src++){
                for(int dst = 1; dst<=n; dst++){
                    if(map[src][mid] == 1 && map[mid][dst] == 1){
                        map[src][dst] = 1;
                        map[dst][src] = -1;
                    }else if(map[src][mid] == -1 && map[mid][dst] == -1){
                        map[src][dst] = -1;
                        map[dst][src] = 1;
                    }
                }
            }
        }
        return (int) Arrays.stream(map).filter(x-> Arrays.stream(x).filter(y->y == 0).count() == 2).count();
    }
}