import java.util.*;

class Solution {
    public int missingInteger(int[] nums) {
        // Step 1: Find longest sequential prefix
        int prefixSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                prefixSum += nums[i];
            } else {
                break;
            }
        }

        // Step 2: Put all nums into a HashSet for O(1) lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 3: Find smallest missing integer >= prefixSum
        int candidate = prefixSum;
        while (set.contains(candidate)) {
            candidate++;
        }

        return candidate;
    }
}
