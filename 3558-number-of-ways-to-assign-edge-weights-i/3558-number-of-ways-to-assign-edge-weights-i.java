class Solution {
    static final int MOD = 1000000007;
    
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // BFS to find max depth
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.add(new int[]{1, 0}); // node, depth
        visited[1] = true;
        
        int maxDepth = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0], depth = cur[1];
            maxDepth = Math.max(maxDepth, depth);
            
            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.add(new int[]{nei, depth+1});
                }
            }
        }
        
        // Result = 2^(maxDepth-1) mod MOD
        return modPow(2, maxDepth-1, MOD);
    }
    
    private int modPow(int base, int exp, int mod) {
        long result = 1, b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * b) % mod;
            b = (b * b) % mod;
            exp >>= 1;
        }
        return (int) result;
    }
}
