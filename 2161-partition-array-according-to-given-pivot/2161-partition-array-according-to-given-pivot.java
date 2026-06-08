class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        
        // Partition elements into three lists
        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }
        
        // Merge results back into nums
        int idx = 0;
        for (int num : less) nums[idx++] = num;
        for (int num : equal) nums[idx++] = num;
        for (int num : greater) nums[idx++] = num;
        
        return nums;
    }
}
