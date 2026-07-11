import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int completeCount = 0;

        // Traverse each component
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> nodes = new ArrayList<>();
                int[] edgeCount = new int[1]; // store edge count for this component
                dfs(i, graph, visited, nodes, edgeCount);

                int k = nodes.size();
                // Each edge counted twice in adjacency list
                int actualEdges = edgeCount[0] / 2;
                int expectedEdges = k * (k - 1) / 2;

                if (actualEdges == expectedEdges) {
                    completeCount++;
                }
            }
        }
        return completeCount;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited,
                     List<Integer> nodes, int[] edgeCount) {
        visited[node] = true;
        nodes.add(node);
        edgeCount[0] += graph.get(node).size();

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs(nei, graph, visited, nodes, edgeCount);
            }
        }
    }
}
