class Solution {
    public String getHappyString(int n, int k) {
        int total = 3 * (1 << (n - 1));
        if (k > total) return "";

        StringBuilder sb = new StringBuilder();
        char[] chars = {'a', 'b', 'c'};
        int blockSize = 1 << (n - 1);

        // Decide first character
        int firstIndex = (k - 1) / blockSize;
        sb.append(chars[firstIndex]);
        k -= firstIndex * blockSize;

        // Build rest
        for (int i = 1; i < n; i++) {
            blockSize >>= 1;
            char prev = sb.charAt(sb.length() - 1);
            char[] options = prev == 'a' ? new char[]{'b','c'} :
                             prev == 'b' ? new char[]{'a','c'} :
                                           new char[]{'a','b'};
            int idx = (k - 1) / blockSize;
            sb.append(options[idx]);
            k -= idx * blockSize;
        }
        return sb.toString();
    }
}
