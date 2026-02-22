class Solution {
    public int binaryGap(int n) {
        int last = -1;   // last index of '1'
        int maxGap = 0;
        int index = 0;   // current bit position

        while (n > 0) {
            if ((n & 1) == 1) {  // check if current bit is 1
                if (last != -1) {
                    maxGap = Math.max(maxGap, index - last);
                }
                last = index;
            }
            n >>= 1;   // move to next bit
            index++;
        }
        return maxGap;
    }
}
