import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // Build adjacency list for graph (method -> invoked methods)
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        
        for (int[] edge : invocations) {
            int from = edge[0], to = edge[1];
            graph.get(from).add(to);
            reverseGraph.get(to).add(from); // reverse edge for incoming check
        }
        
        // Step 1: Find all suspicious methods (reachable from k)
        Set<Integer> suspicious = new HashSet<>();
        dfs(k, graph, suspicious);
        
        // Step 2: Check if any non-suspicious method invokes suspicious ones
        for (int s : suspicious) {
            for (int invoker : reverseGraph.get(s)) {
                if (!suspicious.contains(invoker)) {
                    // Found outside invoker → cannot remove
                    List<Integer> all = new ArrayList<>();
                    for (int i = 0; i < n; i++) all.add(i);
                    return all;
                }
            }
        }
        
        // Step 3: Return remaining methods (non-suspicious ones)
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
    
    private void dfs(int node, List<List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(node)) return;
        visited.add(node);
        for (int nei : graph.get(node)) {
            dfs(nei, graph, visited);
        }
    }
}
