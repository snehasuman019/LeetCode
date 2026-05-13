class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i], b = nums[n - 1 - i];
            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;
            int sum = a + b;

            // Assume 2 moves for all sums
            diff[2] += 2;

            // Reduce to 1 move for sums in [low, high]
            diff[low] -= 1;
            diff[high + 1] += 1;

            // Reduce to 0 moves for sum == a + b
            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }

        int res = Integer.MAX_VALUE;
        int curr = 0;
        for (int s = 2; s <= 2 * limit; s++) {
            curr += diff[s];
            res = Math.min(res, curr);
        }

        return res;
    }
}
