class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : grid) {
            for (int val : row) {
                list.add(val);
            }
        }
        int mod = list.get(0) % x;
        for (int val : list) {
            if (val % x != mod) return -1;
        }
        Collections.sort(list);
        int n = list.size();
        int median = list.get(n / 2);
        long ops = 0;
        for (int val : list) {
            ops += Math.abs(val - median) / x;
        }        
        return (int) ops;
    }
}
