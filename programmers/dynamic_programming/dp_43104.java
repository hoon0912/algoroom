public class dp_43104 {
    public static void main(String[] args){
        System.out.println(solution(6));
    }

    public static long solution(int N) {
        long[] width = new long[81];
        long[] height = new long[81];

        width[1] = 1; height[1] = 1;
        for(int i=2; i<=N; i++) {
            if (i % 2 == 0) {
                width[i] = width[i-1];
                height[i] = width[i-1] + height[i-1];
            }
            else {
                width[i] = width[i-1] + height[i-1];
                height[i] = height[i-1];
            }
        }

        return width[N] * 2 + height[N] * 2;
    }
}
