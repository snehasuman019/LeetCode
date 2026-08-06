class Solution {
    // Helper function to compute product of digits of a number
    private int digitProduct(int num) {
        int product = 1;
        while (num > 0) {
            int digit = num % 10;
            product *= digit;
            num /= 10;
        }
        return product;
    }

    public int smallestNumber(int n, int t) {
        // Start checking from n upwards
        int candidate = n;
        while (true) {
            int product = digitProduct(candidate);
            // If product divisible by t, return candidate
            if (product % t == 0) {
                return candidate;
            }
            candidate++;
        }
    }
}
