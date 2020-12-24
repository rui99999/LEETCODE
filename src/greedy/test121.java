package greedy;

 class test121 {
    public static void main(String[] args) {
        Solution122 solution121 = new Solution122();
        System.out.println(solution121.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = prices[i] - min > max ? prices[i] - min : max;
            }
        }
        return max;
    }
}
class Solution122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max += prices[i] - min;
                min = prices[i];
            }
        }
        return max;
    }
}