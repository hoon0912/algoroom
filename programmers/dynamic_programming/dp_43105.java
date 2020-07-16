public class dp_43105 {
    public static void main(String[] args) {
        int[][] triangle = {{7}};
        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {
        for(int depth = triangle.length - 2; depth >= 0; depth--) {
            for(int i = 0; i < triangle[depth].length; i++) {
                triangle[depth][i] += (triangle[depth+1][i] >= triangle[depth+1][i+1]) ? triangle[depth+1][i] : triangle[depth+1][i+1];
            }
        }
        return triangle[0][0];
    }
}
