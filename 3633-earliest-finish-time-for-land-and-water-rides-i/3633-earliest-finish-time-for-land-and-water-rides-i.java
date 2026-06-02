class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        
        int earliest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int landStart = landStartTime[i];
                int landFinish = landStart + landDuration[i];
                int waterStart = Math.max(landFinish, waterStartTime[j]);
                int waterFinish = waterStart + waterDuration[j];
                earliest = Math.min(earliest, waterFinish);
                int waterStart2 = waterStartTime[j];
                int waterFinish2 = waterStart2 + waterDuration[j];
                int landStart2 = Math.max(waterFinish2, landStartTime[i]);
                int landFinish2 = landStart2 + landDuration[i];
                earliest = Math.min(earliest, landFinish2);
            }
        }

        return earliest;
    }
    public static void main(String[] args) {
        Solution ob = new Solution();

        int[] landStartTime1 = {2, 8};
        int[] landDuration1 = {4, 1};
        int[] waterStartTime1 = {6};
        int[] waterDuration1 = {3};
        System.out.println(ob.earliestFinishTime(landStartTime1, landDuration1, waterStartTime1, waterDuration1));
        int[] landStartTime2 = {5};
        int[] landDuration2 = {3};
        int[] waterStartTime2 = {1};
        int[] waterDuration2 = {10};
        System.out.println(ob.earliestFinishTime(landStartTime2, landDuration2, waterStartTime2, waterDuration2));
    }
}
