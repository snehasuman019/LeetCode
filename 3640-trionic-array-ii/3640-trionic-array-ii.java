/*
class Solution {
    public long maxSumTrionic(int[] nums){
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int[] leftInc = new int[n];
        leftInc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                leftInc[i] = leftInc[i - 1] + 1;
            } else {
                leftInc[i] = 1;
            }
        }
        int[] rightInc = new int[n];
        rightInc[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                rightInc[i] = rightInc[i + 1] + 1;
            } else {
                rightInc[i] = 1;
            }
        }
        int[] midDec = new int[n];
        midDec[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                midDec[i] = midDec[i + 1] + 1;
            } else {
                midDec[i] = 1;
            }
        }
        
        long ans = Long.MIN_VALUE;
        for (int p = 1; p < n - 2; p++) {
            int q = p + 1;
            if (nums[p - 1] < nums[p] && nums[p] > nums[q] && nums[q] < nums[q + 1]) {
                int lenL = leftInc[p];
                int lenM = midDec[p];
                int lenR = rightInc[q];
                
                int l = p - lenL + 1;
                int r = q + lenR - 1;
                
                long sum = prefix[r + 1] - prefix[l];
                ans = Math.max(ans, sum);
            }
        }
        
        return ans;
    }
*/
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



