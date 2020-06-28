import java.util.Arrays;

public class greedy_42884 {
    public static void main(String[] args) {
        int[][] routes = {{0,0},{1,1},{2,2}};
        System.out.println(solution(routes));
    }

    public static int solution(int[][] routes) {  // 범위가 겹치는지 여부는 from을 정렬시키면 쉽게 알 수 있다
        int answer = 0;

        // 효율성 4번 실패 (sort가 오래 걸림)
/*        List<Point> entryExitPoints = IntStream.range(0, routes.length)
                .mapToObj(i -> new Point(routes[i][0], routes[i][1])).sorted(Comparator.comparing(Point::getFrom)).collect(Collectors.toList());
        int common_from = -30001, common_to = 30001;
        for(Point entryExit : entryExitPoints) {
            if (entryExit.getFrom() <= common_to) {
                common_to = Math.min(entryExit.getTo(), common_to);
            }
            else {
                common_to = entryExit.getTo();
                answer++;
            }
        }*/

/*        int common_to = 30001;
        for(int[] fromTo: Arrays.stream(routes).sorted(Comparator.comparing(ints -> ints[0])).collect(Collectors.toList())) {
            if (fromTo[0] <= common_to) {
                common_to = Math.min(fromTo[1], common_to);
            }
            else {
                common_to = fromTo[1];
                answer++;
            }
        }*/

        Arrays.sort(routes, (o1, o2) -> (o1[0] < o2[0]) ? -1 : 1);
        int common_to = 30001;
        for(int[] fromTo : routes) {
            if (fromTo[0] <= common_to) {
                common_to = Math.min(fromTo[1], common_to);
            }
            else {
                common_to = fromTo[1];
                answer++;
            }
        }
        return answer + 1;
    }


/*    public static class Point {
        private int from;
        private int to;

        public Point(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }
    }*/

/*    public static int solution1(int[][] routes) {   // 효율성 실패 1 (가정 : 겹치는 부분이 많은 부분부터 탐욕적으로 처리하면 풀릴 것이다)
        int answer = 0;

        boolean[] isPassed = new boolean[routes.length + 1];
        int passedCarCount = 0;

        while (passedCarCount < routes.length) {
            int[] route = new int[600001];
            IntStream.range(0, routes.length).filter(i -> !isPassed[i]).forEach(i -> IntStream.rangeClosed(routes[i][0] + 30000, routes[i][1] + 30000).forEach(j -> route[j]++));
            int maxIntersection = Arrays.stream(route).max().getAsInt();
            int maxIntersectionIdx = IntStream.rangeClosed(0, 60000).filter(i -> route[i] == maxIntersection).findFirst().getAsInt();

            passedCarCount += maxIntersection;
            IntStream.range(0, routes.length).filter(i -> !isPassed[i]).filter(i -> routes[i][0] + 30000 <= maxIntersectionIdx && maxIntersectionIdx <= routes[i][1] + 30000).forEach(i -> isPassed[i] = true);
            if (maxIntersection > 0) answer++;
        }
        return answer;
    }*/

    /*    public static int solution2(int[][] routes) {  // 효율성 실패 2 (가정 : 길이가 짧은 부분부터 처리하면 풀릴 것이다)
        int answer = 0;
        boolean[] isPassed = new boolean[routes.length];
        List<Point> entryExitPoints = IntStream.range(0, routes.length)
                .mapToObj(i -> new Point(i, routes[i][0], routes[i][1])).sorted(Comparator.comparing(Point::getLength)).collect(Collectors.toList());

        int passedCarCount = 0;
        for(Point entryExit : entryExitPoints) {
            int index = entryExit.getIndex();
            if (isPassed[index]) continue;

            int from = entryExit.getFrom();
            int to = entryExit.getTo();
            int countBetweenFromAndTo = 0;

            for(int i=0; i < routes.length; i++) {
                if (!isPassed[i] && isInRange(routes[i], from, to)) {
                    countBetweenFromAndTo++;
                    isPassed[i] = true;
                }
            }

            if (countBetweenFromAndTo > 0) {
                passedCarCount += countBetweenFromAndTo;
                answer++;

                if (passedCarCount == routes.length) break;
            }
        }
        return answer;
    }*/

/*    public static boolean isInRange(Point entryExit, int from, int to) {
        if (from <= entryExit.getFrom() && entryExit.getTo() <= to) return true; // 포함 된 경우
        if (entryExit.getFrom() <= from && entryExit.getTo() <= to) return true;  // 왼쪽으로만 걸친 경우
        if (entryExit.getFrom() <= to && to <= entryExit.getTo()) return true; // 오른쪽으로만 걸친 경우
        return false;
    }



    public static boolean isInRange(int[] route, int from, int to) {
        if (route[0] <= from && to <= route[1]) return true; // 포함 된 경우
        if (route[0] < from && from <= route[1] && route[1] <= to) return true;  // 왼쪽으로만 걸친 경우
        if (from <= route[0] && route[0] <= to && to < route[1]) return true; // 오른쪽으로만 걸친 경우
        return false;
    }*/
}
