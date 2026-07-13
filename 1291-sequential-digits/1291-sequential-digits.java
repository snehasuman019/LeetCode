import java.util.*;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        
        // All possible sequential digit numbers can be formed from "123456789"
        String digits = "123456789";
        
        // Lengths of numbers we need to consider
        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();
        
        // Generate sequential numbers of lengths between minLen and maxLen
        for (int len = minLen; len <= maxLen; len++) {
            for (int start = 0; start + len <= digits.length(); start++) {
                int num = Integer.parseInt(digits.substring(start, start + len));
                
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        return result;
    }
}
