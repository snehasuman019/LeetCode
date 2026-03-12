import java.util.*;

class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        UnionFind uf = new UnionFind(n);
        int minMandatory = Integer.MAX_VALUE;
        for (int[] e : edges) {
            if (e[3] == 1) {
                if (!uf.union(e[0], e[1])) return -1;
                minMandatory = Math.min(minMandatory, e[2]);
            }
        }
        if (minMandatory == Integer.MAX_VALUE) minMandatory = Integer.MAX_VALUE;
        int lo = 1, hi = 200000;
        int ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canBuild(n, edges, k, mid, uf)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (minMandatory != Integer.MAX_VALUE) ans = Math.min(ans, minMandatory);
        return ans;
    }

    private boolean canBuild(int n, int[][] edges, int k, int target, UnionFind ufBase) {
        UnionFind uf = new UnionFind(n);
        uf.copyFrom(ufBase);
        int upgradesUsed = 0;
        Arrays.sort(edges, (a, b) -> Integer.compare(b[2], a[2]));
        for (int[] e : edges) {
            if (e[3] == 0) {
                int strength = e[2];
                if (strength >= target) {
                    uf.union(e[0], e[1]);
                } else if (strength * 2 >= target) {
                    if (uf.union(e[0], e[1])) {
                        upgradesUsed++;
                        if (upgradesUsed > k) return false;
                    }
                }
            }
        }
        return uf.count == 1;
    }
}

class UnionFind {
    int[] parent, rank;
    int count;
    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    boolean union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return false;
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        count--;
        return true;
    }
    void copyFrom(UnionFind other) {
        System.arraycopy(other.parent, 0, this.parent, 0, other.parent.length);
        System.arraycopy(other.rank, 0, this.rank, 0, other.rank.length);
        this.count = other.count;
    }
}
