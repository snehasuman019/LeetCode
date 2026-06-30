class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] lastSeen = {-1, -1, -1}; // indices for 'a', 'b', 'c'
        int count = 0;

        for (int i = 0; i < n; i++) {
            lastSeen[s.charAt(i) - 'a'] = i;

            // Check if all three characters have been seen
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                int minIndex = Math.min(lastSeen[0], 
                               Math.min(lastSeen[1], lastSeen[2]));
                count += (minIndex + 1);
            }
        }
        return count;
    }
}
