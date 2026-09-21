class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];  // final counts
        long[] dp = new long[k];      // subarrays ending at current index
        
        for (int num : nums) {
            long[] newDp = new long[k];
            int modNum = num % k;
            
            // Start new subarray with just num
            newDp[modNum] += 1;
            
            // Extend previous subarrays
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newR = (int)((r * modNum) % k);
                    newDp[newR] += dp[r];
                }
            }
            
            // Update dp
            dp = newDp;
            
            // Add to global result
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }
        
        return result;
    }
}
