public class Solution {
    public double[] CalcEquation(IList<IList<string>> equations, double[] values, IList<IList<string>> queries) {
        // Step 1: Build graph
        var graph = new Dictionary<string, List<(string, double)>>();

        for (int i = 0; i < equations.Count; i++) {
            string A = equations[i][0];
            string B = equations[i][1];
            double w = values[i];

            if (!graph.ContainsKey(A)) graph[A] = new List<(string, double)>();
            if (!graph.ContainsKey(B)) graph[B] = new List<(string, double)>();

            graph[A].Add((B, w));          // A → B = w
            graph[B].Add((A, 1.0 / w));    // B → A = 1/w
        }

        // Step 2: Answer queries using BFS
        var results = new double[queries.Count];
        for (int i = 0; i < queries.Count; i++) {
            string src = queries[i][0];
            string target = queries[i][1];
            results[i] = BFS(src, target, graph);
        }

        return results;
    }

    private double BFS(string src, string target, Dictionary<string, List<(string, double)>> graph) {
        // Handle undefined variables
        if (!graph.ContainsKey(src) || !graph.ContainsKey(target)) return -1.0;
        if (src == target) return 1.0;

        var visited = new HashSet<string> { src };
        var queue = new Queue<(string node, double product)>();
        queue.Enqueue((src, 1.0));

        while (queue.Count > 0) {
            var (node, product) = queue.Dequeue();

            if (node == target) return product;

            foreach (var (neighbor, weight) in graph[node]) {
                if (!visited.Contains(neighbor)) {
                    visited.Add(neighbor);
                    queue.Enqueue((neighbor, product * weight));
                }
            }
        }

        return -1.0; // no path found
    }
}