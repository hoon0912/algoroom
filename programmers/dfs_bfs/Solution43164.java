package dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 여행경로
class Solution43164 {
    private List<String> list;
    private boolean visited[];
    private String route = "";

    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        visited = new boolean[tickets.length];

        for (int i = 0; i < tickets.length; i++) {
            String departure = tickets[i][0];
            String destination = tickets[i][1];

            if (!"ICN".equals(departure)) continue;

            visited[i] = true;
            route = departure + ",";
            dfs(destination, 1, tickets);
            visited[i] = false;
        }

        Collections.sort(list);
        return list.get(0).split(",");
    }

    private void dfs(String currentDeparture, int count, String[][] tickets){
        route += currentDeparture + ",";

        if (count == tickets.length){
            list.add(route);
        } else {
            for (int i = 0; i < tickets.length; i++) {
                String departure = tickets[i][0];
                String destination = tickets[i][1];

                if (!visited[i] && currentDeparture.equals(departure)) {
                    visited[i] = true;
                    dfs(destination, count + 1, tickets);
                    visited[i] = false;
                    route = route.substring(0, route.length() - 4);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution43164 solution = new Solution43164();

        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[] result = solution.solution(tickets);
        System.out.println(Arrays.toString(result)); // [ICN, JFK, HND, IAD]

        tickets = new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        result = solution.solution(tickets);
        System.out.println(Arrays.toString(result)); // [ICN, ATL, ICN, SFO, ATL, SFO]
    }
}
