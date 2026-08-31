class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> criticalIndices = new ArrayList<>();
        int index = 1; // start from second node
        ListNode prev = head, curr = head.next;

        while (curr.next != null) {
            int nextVal = curr.next.val;
            if ((curr.val > prev.val && curr.val > nextVal) ||
                (curr.val < prev.val && curr.val < nextVal)) {
                criticalIndices.add(index);
            }
            prev = curr;
            curr = curr.next;
            index++;
        }

        if (criticalIndices.size() < 2) return new int[]{-1, -1};

        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i < criticalIndices.size(); i++) {
            minDist = Math.min(minDist, criticalIndices.get(i) - criticalIndices.get(i - 1));
        }
        int maxDist = criticalIndices.get(criticalIndices.size() - 1) - criticalIndices.get(0);

        return new int[]{minDist, maxDist};
    }
}
