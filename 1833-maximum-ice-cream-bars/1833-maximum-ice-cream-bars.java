class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;
        for (int c : costs) maxCost = Math.max(maxCost, c);

        int[] count = new int[maxCost + 1];
        for (int c : costs) count[c]++;

        int bars = 0;
        for (int price = 1; price <= maxCost; price++) {
            if (count[price] == 0) continue;
            int canBuy = Math.min(count[price], coins / price);
            bars += canBuy;
            coins -= canBuy * price;
            if (coins < price) break;
        }
        return bars;
    }
}
