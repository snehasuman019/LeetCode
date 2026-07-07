import java.util.*;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // Step 1: Sort intervals
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // same start → sort by end descending
            }
            return a[0] - b[0]; // sort by start ascending
        });

        // Step 2: Iterate and count non-covered intervals
        int count = 0;
        int maxRight = -1;

        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];

            if (right <= maxRight) {
                // Covered → skip
                continue;
            } else {
                // Not covered → count it
                count++;
                maxRight = right;
            }
        }

        return count;
    }
}
