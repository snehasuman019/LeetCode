

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        Arrays.sort(freq); // sort ascending
        int pushes = 0;
        int idx = 25; // start from highest frequency
        
        int cost = 1;
        int count = 0;
        
        while (idx >= 0 && freq[idx] > 0) {
            pushes += freq[idx] * cost;
            idx--;
            count++;
            if (count == 8) { // after 8 letters, increase cost
                cost++;
                count = 0;
            }
        }
        
        return pushes;
    }
}
