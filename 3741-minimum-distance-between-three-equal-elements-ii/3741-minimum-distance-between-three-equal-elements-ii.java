class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int minDist = Integer.MAX_VALUE;
        for (List<Integer> indices : map.values()) {
            if (indices.size() >= 3) {
                for (int i = 0; i + 2 < indices.size(); i++) {
                    int dist = 2 * (indices.get(i + 2) - indices.get(i));
                    minDist = Math.min(minDist, dist);
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
