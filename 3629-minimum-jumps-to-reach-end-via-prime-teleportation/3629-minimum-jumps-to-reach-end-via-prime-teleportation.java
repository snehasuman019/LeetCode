import java.util.*;

class Solution {

    public int minJumps(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int num = nums[i];
            for (int p : getPrimeFactors(num)) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                if (idx == n - 1)
                    return steps;
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }
                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }
                if (isPrime(nums[idx])) {

                    int prime = nums[idx];

                    if (map.containsKey(prime)) {

                        for (int next : map.get(prime)) {

                            if (!visited[next]) {
                                visited[next] = true;
                                q.offer(next);
                            }
                        }
                        map.remove(prime);
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean isPrime(int x) {

        if (x < 2)
            return false;

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }

        return true;
    }
    private List<Integer> getPrimeFactors(int x) {

        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i * i <= x; i++) {

            if (x % i == 0) {

                factors.add(i);

                while (x % i == 0)
                    x /= i;
            }
        }

        if (x > 1)
            factors.add(x);

        return factors;
    }
}