import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        // Step 1: Pair values with indices
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i]; // value
            arr[i][1] = i;       // index
        }
        
        // Step 2: Sort by value
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Step 3: Process groups
        int[] result = new int[n];
        int start = 0;
        
        while (start < n) {
            int end = start;
            // Expand group while consecutive values differ ≤ limit
            while (end + 1 < n && arr[end + 1][0] - arr[end][0] <= limit) {
                end++;
            }
            
            // Collect indices and values for this group
            List<Integer> indices = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                indices.add(arr[i][1]);
                values.add(arr[i][0]);
            }
            
            // Sort indices and values separately
            Collections.sort(indices);
            Collections.sort(values);
            
            // Assign smallest values to smallest indices
            for (int i = 0; i < indices.size(); i++) {
                result[indices.get(i)] = values.get(i);
            }
            
            start = end + 1;
        }
        
        return result;
    }
}
