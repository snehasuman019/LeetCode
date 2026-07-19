import java.util.*;

class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int[] lastIndex = new int[26]; // last occurrence of each char
        boolean[] seen = new boolean[26]; // track if char already in stack
        
        // Step 1: Record last occurrence of each character
        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        // Step 2: Use stack to build result
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            
            // Skip if already in stack
            if (seen[idx]) continue;
            
            // Maintain lexicographic order
            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false; // mark popped char as unseen
            }
            
            stack.push(c);
            seen[idx] = true;
        }
        
        // Step 3: Build final string
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        
        return sb.toString();
    }
}
