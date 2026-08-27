import java.util.*;
class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        StringBuilder result = new StringBuilder();
        if (dfs(0, freq, target, result, false)) {
            return result.toString();
        }
        return "";
    }
    private boolean dfs(int idx, int[] freq, String target, StringBuilder result, boolean alreadyGreater) {
        if (idx == target.length()) return alreadyGreater;
        for (int c = 0; c < 26; c++) {
            if (freq[c] == 0) continue;
            char ch = (char) (c + 'a');
            freq[c]--;
            result.append(ch);
            if (alreadyGreater) {
                if (dfs(idx + 1, freq, target, result, true)) return true;
            } else {
                if (ch > target.charAt(idx)) {
                    if (dfs(idx + 1, freq, target, result, true)) return true;
                } else if (ch == target.charAt(idx)) {
                    if (dfs(idx + 1, freq, target, result, false)) return true;
                }
            }
            result.deleteCharAt(result.length() - 1);
            freq[c]++;
        }
        return false;
    }
}
