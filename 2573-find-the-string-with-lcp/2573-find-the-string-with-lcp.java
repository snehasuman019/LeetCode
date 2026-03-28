class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];
        Arrays.fill(word, '?');
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] > 0) {
                    union(parent, i, j);
                }
            }
        }
        Map<Integer, Character> groupChar = new HashMap<>();
        char nextChar = 'a';
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            if (!groupChar.containsKey(root)) {
                if (nextChar > 'z') return ""; 
                groupChar.put(root, nextChar++);
            }
            word[i] = groupChar.get(root);
        }
        if (!validate(word, lcp)) return "";
        return new String(word);
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        if (pa != pb) parent[pa] = pb;
    }

    private boolean validate(char[] word, int[][] lcp) {
        int n = word.length;
        int[][] calc = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    if (i == n - 1 || j == n - 1) calc[i][j] = 1;
                    else calc[i][j] = 1 + calc[i + 1][j + 1];
                }
            }
        }
        return Arrays.deepEquals(calc, lcp);
    }
}
