

class Solution {
    public int findGCD(int[] nums) {
        // Step 1: Find smallest and largest numbers in the array
        int min = nums[0];
        int max = nums[0];
        
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        // Step 2: Compute GCD of min and max using Euclidean algorithm
        return gcd(min, max);
    }
    
    // Helper function to compute GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
