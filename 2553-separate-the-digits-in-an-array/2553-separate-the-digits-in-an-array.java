import java.util.*;

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int num : nums) {
            // Convert number to string
            String s = String.valueOf(num);
            // Add each digit to result
            for (char c : s.toCharArray()) {
                result.add(c - '0'); // convert char digit to int
            }
        }
        
        // Convert List<Integer> to int[]
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
