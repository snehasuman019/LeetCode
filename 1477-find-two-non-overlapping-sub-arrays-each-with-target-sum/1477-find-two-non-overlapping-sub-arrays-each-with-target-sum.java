class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, -1);

        int sum = 0;
        int res = Integer.MAX_VALUE;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (prefix.containsKey(sum - target)) {
                int start = prefix.get(sum - target) + 1;
                int length = i - start + 1;

                if (start > 0 && best[start - 1] != Integer.MAX_VALUE) {
                    res = Math.min(res, length + best[start - 1]);
                }
                minLen = Math.min(minLen, length);
            }

            best[i] = minLen;
            prefix.put(sum, i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
