class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        final int MOD = 1_000_000_007;
        for (int[] query : queries) {
            int li = query[0], ri = query[1], ki = query[2], vi = query[3];
            
            for (int idx = li; idx <= ri; idx += ki) {
                nums[idx] = (int)((long)nums[idx] * vi % MOD);
            }
        }
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }
        return xorResult;
    }
}
