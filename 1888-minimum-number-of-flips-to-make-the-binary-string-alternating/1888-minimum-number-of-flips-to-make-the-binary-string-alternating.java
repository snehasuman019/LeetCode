class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String doubled = s + s;
        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();

        for (int i = 0; i < 2 * n; i++) {
            alt1.append(i % 2 == 0 ? '0' : '1');
            alt2.append(i % 2 == 0 ? '1' : '0');
        }

        int res = n;
        int diff1 = 0, diff2 = 0;

        for (int i = 0; i < 2 * n; i++) {
            if (doubled.charAt(i) != alt1.charAt(i)) diff1++;
            if (doubled.charAt(i) != alt2.charAt(i)) diff2++;

            if (i >= n) {
                if (doubled.charAt(i - n) != alt1.charAt(i - n)) diff1--;
                if (doubled.charAt(i - n) != alt2.charAt(i - n)) diff2--;
            }

            if (i >= n - 1) {
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }
        return res;  
    }
}
