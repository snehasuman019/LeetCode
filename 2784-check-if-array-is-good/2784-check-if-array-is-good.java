import java.util.*;

class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        if (n != max + 1) return false;
        
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i < max; i++) {
            if (freq.getOrDefault(i, 0) != 1) return false;
        }
        return freq.getOrDefault(max, 0) == 2;
    }
}
