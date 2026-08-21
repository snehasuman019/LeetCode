class Solution {
    public long findKthSmallest(int[] coins, int k) {
        // Step 1: Remove redundant coins (if one coin divides another, keep only the smaller)
        Arrays.sort(coins);
        List<Integer> filtered = new ArrayList<>();
        for (int c : coins) {
            boolean keep = true;
            for (int f : filtered) {
                if (c % f == 0) { // redundant
                    keep = false;
                    break;
                }
            }
            if (keep) filtered.add(c);
        }
        int[] arr = filtered.stream().mapToInt(i -> i).toArray();

        // Step 2: Binary search
        long left = 1, right = (long) 1e18; // upper bound
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (count(arr, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Count how many distinct amounts ≤ x
    private long count(int[] coins, long x) {
        int n = coins.length;
        long res = 0;
        // Inclusion-Exclusion over subsets
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            boolean overflow = false;
            int bits = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    lcm = lcm(lcm, coins[i]);
                    if (lcm > x) { // no contribution
                        overflow = true;
                        break;
                    }
                }
            }
            if (!overflow) {
                long cnt = x / lcm;
                if (bits % 2 == 1) res += cnt; // odd subset → add
                else res -= cnt;              // even subset → subtract
            }
        }
        return res;
    }

    // Compute LCM safely
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
