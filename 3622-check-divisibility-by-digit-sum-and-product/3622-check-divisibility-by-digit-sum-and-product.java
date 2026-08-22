class Solution {
    public boolean checkDivisibility(int n) {
        // Step 1: Initialize sum and product of digits
        int digitSum = 0;
        int digitProduct = 1;
        
        // Step 2: Extract digits of n
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;   // get last digit
            digitSum += digit;       // add to sum
            digitProduct *= digit;   // multiply to product
            temp /= 10;              // remove last digit
        }
        
        // Step 3: Calculate total = sum + product
        int total = digitSum + digitProduct;
        
        // Step 4: Check divisibility
        return n % total == 0;
    }
}
