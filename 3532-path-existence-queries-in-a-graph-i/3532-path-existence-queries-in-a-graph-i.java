class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Step 1: Assign component IDs
        int[] component = new int[n];
        int compId = 0;
        component[0] = compId;
        
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                component[i] = compId; // same component
            } else {
                compId++;              // new component
                component[i] = compId;
            }
        }
        
        // Step 2: Answer queries
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            answer[i] = (component[u] == component[v]);
        }
        
        return answer;
    }
}
