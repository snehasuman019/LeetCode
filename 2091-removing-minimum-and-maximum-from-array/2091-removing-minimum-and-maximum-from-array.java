class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        
        // Find indices of min and max
        int minIndex = 0, maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) minIndex = i;
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        
        // Ensure minIndex < maxIndex for easier handling
        if (minIndex > maxIndex) {
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }
        
        // Case 1: Remove both from front
        int front = maxIndex + 1;
        
        // Case 2: Remove both from back
        int back = n - minIndex;
        
        // Case 3: Remove one from front, one from back
        int mixed = (minIndex + 1) + (n - maxIndex);
        
        // Return minimum of all strategies
        return Math.min(front, Math.min(back, mixed));
    }
}
