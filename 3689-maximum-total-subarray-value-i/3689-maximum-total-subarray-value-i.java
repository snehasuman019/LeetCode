class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        
        // Find max and min in the array
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
        }
        
        // Maximum difference
        long diff = (long) maxVal - (long) minVal;
        
        // Multiply by k
        return diff * k;
    }
}
