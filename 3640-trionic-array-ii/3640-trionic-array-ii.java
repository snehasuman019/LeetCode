class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long[] dp0 = new long[n];
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        long[] dp3 = new long[n];

        dp0[0] = nums[0];
        dp1[0] = dp2[0] = dp3[0] = Long.MIN_VALUE / 2;

        long ans = Long.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            dp0[i] = nums[i]; // fresh start

            if (nums[i] > nums[i-1]) {
                dp1[i] = Math.max(dp1[i-1] + nums[i], dp0[i-1] + nums[i]);
                dp3[i] = Math.max(dp3[i-1] + nums[i], dp2[i-1] + nums[i]);
            } else {
                dp1[i] = Long.MIN_VALUE / 2;
                dp3[i] = Long.MIN_VALUE / 2;
            }

            if (nums[i] < nums[i-1]) {
                dp2[i] = Math.max(dp2[i-1] + nums[i], dp1[i-1] + nums[i]);
            } else {
                dp2[i] = Long.MIN_VALUE / 2;
            }

            ans = Math.max(ans, dp3[i]);
        }

        return ans;
    }
}
