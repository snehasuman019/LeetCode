class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0, right = (long)1e18, ans = right;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canReduce(mountainHeight, workerTimes, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean canReduce(int mountainHeight, int[] workerTimes, long T) {
        long total = 0;
        for (int w : workerTimes) {
            long maxX = (long)(Math.sqrt(1 + 8.0 * T / w) - 1) / 2;
            total += maxX;
            if (total >= mountainHeight) return true;
        }
        return total >= mountainHeight;
    }
}
