import java.util.stream.IntStream;

public class bruteforce_42841 {
    public static void main(String[] args) {
        int[][] baseball = {{123,1,1},{356,1,0},{327,2,0},{489,0,1}};
        int result = solution(baseball);
        System.out.println(result);
    }

    public static int solution(int[][] baseball) {
        int answer = 0;
        for(int a=1; a<=9; a++) {
            for(int b=1; b<=9; b++) {
                if (a == b) continue;
                for(int c=1; c<=9; c++) {
                    if (a == c || b == c) continue;

                    int answerNum = a * 100 + b * 10 + c;
                    if (isPossible(baseball, answerNum)) answer++;
                }
            }
        }
        return answer;
    }

    public static boolean isPossible(int[][] baseball, int answerNum) {
        boolean[] answerMap = new boolean[10];  // default 0 (false)
        String.valueOf(answerNum).chars().map(asciiNum -> asciiNum - 48).forEach(digit -> answerMap[digit] = true);

        for(int i=0; i<baseball.length; i++) {
            boolean[] tryMap = new boolean[10];
            int tryNumber = baseball[i][0];
            String.valueOf(tryNumber).chars().map(asciiNum -> asciiNum - 48).forEach(digit -> tryMap[digit] = true);

            int tryResult_strike = baseball[i][1];
            int tryResult_ball = baseball[i][2];

            int answerResult_strike = (int) IntStream.rangeClosed(1, (int)Math.log10(answerNum)+1).filter(pos -> (int) ((answerNum / Math.pow(10, pos - 1)) % 10) == (int) ((tryNumber / Math.pow(10, pos - 1)) % 10) ).count();
            int answerResult_ball = (int) IntStream.rangeClosed(1,9).filter(k -> answerMap[k] && tryMap[k]).count() - answerResult_strike;

            if (tryResult_strike != answerResult_strike || tryResult_ball != answerResult_ball) {
                return false;
            }
        }
        return true;
    }
}
