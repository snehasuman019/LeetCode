class Fancy {
    private static final int MOD = 1_000_000_007;
    private List<Long> seq;
    private long add = 0;
    private long mul = 1;
    public Fancy() {
        seq = new ArrayList<>();
    }
    public void append(int val) {
        long adjusted = (val - add + MOD) % MOD;
        adjusted = (adjusted * modInverse(mul)) % MOD;
        seq.add(adjusted);
    }
    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }
    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }
    public int getIndex(int idx) {
        if (idx >= seq.size()) return -1;
        long val = (seq.get(idx) * mul + add) % MOD;
        return (int) val;
    }
    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }
    private long pow(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}


/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */