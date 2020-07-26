import java.util.Arrays;

public class dp_42899 {
    public static void main(String[] args) {
        int[][] travle = {{500, 200, 200, 100}, {800, 370, 300, 120}, {700, 250, 300, 90}};
        int K = 1650;
        System.out.println(solution(K, travle));
    }

    public static int solution(int K, int[][] travel) {
        int[][] money = new int[travel.length+1][K+1];

        for(int i=0; i<travel.length; i++) {
            int walk_time = travel[i][0];
            int walk_money = travel[i][1];
            int bike_time = travel[i][2];
            int bike_money = travel[i][3];


            for(int j=0; j<K; j++) {
                if (i == 0 || money[i][j] > 0) {
                    if (j + walk_time <= K && money[i+1][j + walk_time] < money[i][j] + walk_money) money[i+1][j + walk_time] = money[i][j] + walk_money;
                    if (j + bike_time <= K && money[i+1][j + bike_time] < money[i][j] + bike_money) money[i+1][j + bike_time] = money[i][j] + bike_money;

                    if (i==0) break;
                }
            }
        }
        return Arrays.stream(money[travel.length]).filter(x -> x > 0).max().getAsInt();
    }
}
