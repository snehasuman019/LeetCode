import java.util.*;

class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        
        // Track positions
        int[] firstUpper = new int[26];
        int[] lastLower = new int[26];
        Arrays.fill(firstUpper, -1);
        Arrays.fill(lastLower, -1);
        
        // Traverse string
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch)) {
                lastLower[ch - 'a'] = i; // last occurrence of lowercase
            } else {
                if (firstUpper[ch - 'A'] == -1) {
                    firstUpper[ch - 'A'] = i; // first occurrence of uppercase
                }
            }
        }
        
        int count = 0;
        // Check each letter
        for (int i = 0; i < 26; i++) {
            if (lastLower[i] != -1 && firstUpper[i] != -1 && lastLower[i] < firstUpper[i]) {
                count++;
            }
        }
        
        return count;
    }
}
