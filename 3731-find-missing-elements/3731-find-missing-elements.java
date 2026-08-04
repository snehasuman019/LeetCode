import java.util.*;
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        // Step 1: Find min and max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Step 2: Store nums in a HashSet for O(1) lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 3: Collect missing numbers
        List<Integer> missing = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                missing.add(i);
            }
        }

        return missing;
    }
}
