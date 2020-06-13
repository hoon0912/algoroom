import java.util.Arrays;

public class sort_42748 {
    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        int[] result = solution(array, commands);
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            int from = commands[i][0];
            int to = commands[i][1];
            int k = commands[i][2];
            answer[i] = getKth(Arrays.copyOfRange(array, from-1, to), k);
        }
        return answer;
    }

    public static int getKth(int[] tempArray, int k) {
        Arrays.sort(tempArray);
        return tempArray[k-1];
    }
}
