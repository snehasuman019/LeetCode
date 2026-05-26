import java.util.*;

class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> lowerSet = new HashSet<>();
        Set<Character> upperSet = new HashSet<>();
        
        // Collect lowercase and uppercase letters
        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lowerSet.add(ch);
            } else {
                upperSet.add(ch);
            }
        }
        
        int count = 0;
        // Check overlap
        for (char ch : lowerSet) {
            if (upperSet.contains(Character.toUpperCase(ch))) {
                count++;
            }
        }
        
        return count;
    }
}
