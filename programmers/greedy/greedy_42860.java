import java.util.Arrays;
import java.util.stream.IntStream;

public class greedy_42860 {
    public static void main(String[] args) {
        String name = "JAN";
        System.out.println(solution(name));
    }

    /**
     * 조이스틱 최소 움직임 개수 구하기 = 조이스틱 위아래 최소 개수 + 조이스틱 좌우 최소 개수
     * 조이스틱 위아래 최소 개수 = A-Z로 이루어진 Circular Array가 있다고 가정하고 양 방향 결과의 최소값
     * 조이스틱 좌우 최수 개수 = 현재 위치에서 좌우 방향 중에서 어느쪽이 더 가까운 위아래 변경이 필요한지 distance를 측정. 그리고 현재 위치를 계속 갱신
     * */
    public static int solution(String name) {
        int upDown = name.chars().map(ascii -> Math.min(ascii - 'A', 'Z'+1 - ascii)).sum();

        Boolean[] needsToUpDown = new Boolean[name.length()];
        IntStream.range(0, name.length()).forEach(i -> needsToUpDown[i] = name.charAt(i) != 'A');

        int needsToUpDownCount = (int) Arrays.stream(needsToUpDown).filter(i -> i == true).count();
        int leftRight = 0;
        int startIdx = 0;
        while (needsToUpDownCount > 0) {
            int p_distance = 0, p_index = 0;
            for(int right = startIdx; ; right++) {
                if (needsToUpDown[right % name.length()]) { p_index = right % name.length(); break; }
                p_distance++;
            }

            int m_distance = 0, m_index = 0;
            for(int left = startIdx; ; left--) {
                if (needsToUpDown[(name.length() + left) % name.length()])  { m_index = (name.length() + left) % name.length(); break; }
                m_distance++;
            }

            int distance, idx;
            if (p_distance <= m_distance) {
                distance = p_distance;
                idx = p_index;
            }
            else {
                distance = m_distance;
                idx = m_index;
            }

            needsToUpDown[idx] = false;
            needsToUpDownCount--;

            leftRight += distance;
            startIdx = idx;
        }
        return upDown + leftRight;
    }
}
