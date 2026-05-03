class Solution {
    public boolean rotateString(String s, String goal) {
        // Lengths must match, otherwise impossible
        if (s.length() != goal.length()) {
            return false;
        }
        // Check if goal is a substring of s+s
        String doubled = s + s;
        return doubled.contains(goal);
    }
}
