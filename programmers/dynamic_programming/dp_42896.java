public class dp_42896 {
    public static void main(String[] args) {
        int[] left = {3,2,5};
        int[] right = {2,4,1};
        System.out.println(solution(left, right));
    }

    public static int solution(int[] left, int[] right) {
        final int LEFT_MAX = left.length + 1;
        final int RIGHT_MAX = right.length + 1;

        boolean[][] routeMap = new boolean[LEFT_MAX][RIGHT_MAX];
        int[][] scoreMap = new int[LEFT_MAX][RIGHT_MAX];

        routeMap[0][0] = true;
        for(int leftIdx=0; leftIdx<LEFT_MAX; leftIdx++) {
            for(int rightIdx=0; rightIdx<RIGHT_MAX; rightIdx++) {
                if (routeMap[leftIdx][rightIdx]) {
                    if (leftIdx == left.length || rightIdx == right.length) continue;

                    if (leftIdx + 1 < LEFT_MAX) routeMap[leftIdx+1][rightIdx] = true;  // 아래로 항상 갈 수 있음
                    if (leftIdx + 1 < LEFT_MAX && rightIdx + 1 < RIGHT_MAX) routeMap[leftIdx+1][rightIdx+1] = true;  // 우측 대각선으로도 항상 갈 수 있음
                    if (rightIdx + 1 < RIGHT_MAX && left[leftIdx] > right[rightIdx]) routeMap[leftIdx][rightIdx+1] = true;  // 오른쪽으로 가는 것은 조건 충족되어야 함
                }
                else
                    break;
            }
        } // 지나갈 수 있는 경로 맵 획득

        for(int leftIdx=0; leftIdx<LEFT_MAX; leftIdx++) {
            for(int rightIdx=0; rightIdx<RIGHT_MAX; rightIdx++) {
                if(routeMap[leftIdx][rightIdx]) {
                    int temp = 0;
                    if (leftIdx-1 >= 0 && routeMap[leftIdx-1][rightIdx]) temp = Math.max(temp, scoreMap[leftIdx-1][rightIdx]);   // 위
                    if (leftIdx-1 >= 0 && rightIdx-1 >= 0 && routeMap[leftIdx-1][rightIdx-1]) temp = Math.max(temp, scoreMap[leftIdx-1][rightIdx-1]);  // 대각선
                    if (rightIdx-1 >= 0 && leftIdx < left.length && routeMap[leftIdx][rightIdx-1] && left[leftIdx] > right[rightIdx-1]) temp = Math.max(temp, scoreMap[leftIdx][rightIdx-1] + right[rightIdx-1]);  // 왼쪽
                    scoreMap[leftIdx][rightIdx] = temp;
                }
            }
        } // 스코어 맵 획득


        return scoreMap[left.length][right.length];
    }
}
