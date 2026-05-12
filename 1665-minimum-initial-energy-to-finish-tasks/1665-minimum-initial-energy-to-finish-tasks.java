import java.util.*;
class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int total = 0;
        int initial = 0; 
        for (int[] task : tasks) {
            total += task[0];
            initial = Math.max(initial, total + (task[1] - task[0]));
        }
        return initial;
    }
}
