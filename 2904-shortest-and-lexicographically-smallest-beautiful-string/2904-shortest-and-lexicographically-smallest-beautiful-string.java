class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0, countOnes = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                countOnes++;
            }

            // Shrink window when we have exactly k ones
            while (countOnes == k) {
                int currLen = right - left + 1;
                String candidate = s.substring(left, right + 1);

                if (currLen < minLen || (currLen == minLen && candidate.compareTo(result) < 0)) {
                    minLen = currLen;
                    result = candidate;
                }

                // Move left pointer
                if (s.charAt(left) == '1') {
                    countOnes--;
                }
                left++;
            }
        }

        return result;
    }
}
