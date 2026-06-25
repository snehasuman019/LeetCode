class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (nums[i] == target) ? 1 : -1;
        }
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        long[] sorted = prefix.clone();
        Arrays.sort(sorted);
        Map<Long, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            indexMap.put(sorted[i], i + 1);
        }
        Fenwick fenwick = new Fenwick(sorted.length + 2);
        int result = 0;
        for (long p : prefix) {
            int idx = indexMap.get(p);
            result += fenwick.query(idx - 1);
            fenwick.update(idx, 1);
        }
        return result;
    }
    static class Fenwick {
        int[] bit;
        Fenwick(int n) { bit = new int[n]; }
        
        void update(int i, int delta) {
            while (i < bit.length) {
                bit[i] += delta;
                i += i & -i;
            }
        }
        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}
