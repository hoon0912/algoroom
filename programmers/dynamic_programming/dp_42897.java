
public class dp_42897 {
    public static void main(String[] args) {
        int[] money = {1,2,3,4,5};
        System.out.println(solution(money));
    }

    public static int solution(int[] money) {
        int[] from_start = new int[money.length];
        int[] from_next = new int[money.length];

        from_start[0] = money[0];
        from_start[1] = from_start[0];
        for(int i=2; i<money.length; i++) {
            from_start[i] = Math.max(from_start[i-2] + money[i], from_start[i-1]);
        }

        from_next[1] = money[1];
        for(int i=2; i<money.length; i++) {
            from_next[i] = Math.max(from_next[i-2] + money[i], from_next[i-1]);
        }

        return Math.max(from_start[money.length-2], from_next[money.length-1]);
    }
}
