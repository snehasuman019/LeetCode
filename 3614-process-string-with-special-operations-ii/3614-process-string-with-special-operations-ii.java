class Solution {
    public char processStr(String s, long k) {
        // Step 1: Track the length of the result after each operation
        long[] length = new long[s.length() + 1];
        length[0] = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                length[i + 1] = length[i] + 1;
            } else if (c == '*') {
                length[i + 1] = Math.max(0, length[i] - 1);
            } else if (c == '#') {
                length[i + 1] = Math.min((long)1e15, length[i] * 2);
            } else if (c == '%') {
                length[i + 1] = length[i]; // reversal doesn’t change length
            }
        }

        // If k is out of bounds
        if (k >= length[s.length()]) return '.';

        // Step 2: Work backwards to find the k-th character
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                if (length[i] == k) return c; // found the character
                if (length[i] < k + 1) k--;   // adjust index
            } else if (c == '*') {
                // '*' removed last char, so skip
                if (length[i] < length[i + 1]) {
                    // if removal happened, adjust k
                    if (k == length[i]) return '.';
                }
            } else if (c == '#') {
                // duplication: figure out which half k belongs to
                if (k >= length[i]) {
                    k -= length[i];
                }
            } else if (c == '%') {
                // reversal: map k to mirrored index
                k = length[i] - 1 - k;
            }
        }

        return '.'; // fallback
    }
}
