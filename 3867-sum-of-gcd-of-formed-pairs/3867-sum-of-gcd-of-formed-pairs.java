import java.util.*;

class Solution {
    // Helper function to compute gcd
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        long[] prefixGcd = new long[n];

        // Step 1: Build prefixGcd array
        int maxSoFar = nums[0];
        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            prefixGcd[i] = gcd(nums[i], maxSoFar);
        }

        // Step 2: Sort prefixGcd
        Arrays.sort(prefixGcd);

        // Step 3: Pair smallest with largest
        long sum = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            sum += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }

        return sum;
    }
}
