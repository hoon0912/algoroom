import java.util.LinkedList;
import java.util.Queue;

public class dp_42898 {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};
        System.out.println(solution(m,n,puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {
        if (m == 1 && n == 1) return 0;

        int[][] cost_map = new int[n+1][m+1];
        int[][] count_map = new int[n+1][m+1];
        for(int[] puddle : puddles) {
            cost_map[puddle[1]][puddle[0]] = -1;
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(m,n));
        count_map[n][m] = 1;
        while (!q.isEmpty()) {
            Point current_point = q.poll();
            int current_x = current_point.getX();
            int current_y = current_point.getY();

            if (current_x - 1 >= 0 && cost_map[current_y][current_x-1] != -1) {  // 왼쪽
                if (cost_map[current_y][current_x-1] == 0) {
                    cost_map[current_y][current_x-1] = cost_map[current_y][current_x] + 1;
                    count_map[current_y][current_x-1] += count_map[current_y][current_x] % 1000000007;
                    q.add(new Point(current_x-1, current_y));
                }
                else if (cost_map[current_y][current_x-1] == cost_map[current_y][current_x] + 1) {
                    count_map[current_y][current_x-1] += count_map[current_y][current_x] % 1000000007;
                }
            }

            if (current_y - 1 >= 0 && cost_map[current_y-1][current_x] != -1) {  // 위쪽
                if (cost_map[current_y-1][current_x] == 0) {
                    cost_map[current_y-1][current_x] = cost_map[current_y][current_x] + 1;
                    count_map[current_y-1][current_x] += count_map[current_y][current_x] % 1000000007;
                    q.add(new Point(current_x, current_y-1));
                } else if (cost_map[current_y-1][current_x] == cost_map[current_y][current_x] + 1) {
                    count_map[current_y-1][current_x] += count_map[current_y][current_x] % 1000000007;
                }
            }
        }
        return count_map[1][1] % 1000000007;
    }

    public static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
