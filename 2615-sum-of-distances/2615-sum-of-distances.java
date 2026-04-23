class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> indices : map.values()) {
            int size = indices.size();
            long[] prefix = new long[size + 1];
            for (int i = 0; i < size; i++) {
                prefix[i + 1] = prefix[i] + indices.get(i);
            }
            for (int i = 0; i < size; i++) {
                int idx = indices.get(i);
                long left = (long) i * idx - prefix[i];
                long right = (prefix[size] - prefix[i + 1]) - (long)(size - i - 1) * idx;
                result[idx] = left + right;
            }
        }
        return result;
    }
}
