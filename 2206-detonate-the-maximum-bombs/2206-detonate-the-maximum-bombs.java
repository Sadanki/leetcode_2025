class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> graph = new ArrayList<>();

        // Step 1: Build the graph
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            long x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long x2 = bombs[j][0], y2 = bombs[j][1];
                long dx = x1 - x2, dy = y1 - y2;
                if (dx * dx + dy * dy <= r1 * r1) {
                    graph.get(i).add(j); // i can detonate j
                }
            }
        }

        // Step 2: DFS from each node
        int max = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            dfs(i, graph, visited);
            max = Math.max(max, visited.size());
        }

        return max;
    }

    private void dfs(int node, List<List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(node)) return;
        visited.add(node);
        for (int nei : graph.get(node)) {
            dfs(nei, graph, visited);
        }
    }
}