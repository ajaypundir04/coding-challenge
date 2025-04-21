package dp;

import java.util.Arrays;

public class CoinChangeMemo {

    public static int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2); // Use -2 to indicate uncomputed values
        return helper(coins, amount, memo);
    }

    private static int helper(int[] coins, int rem, int[] memo) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;

        if (memo[rem] != -2) return memo[rem]; // Already computed

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = helper(coins, rem - coin, memo);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }

        memo[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[rem];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount)); // Output: 3 (5+5+1)
    }
}
