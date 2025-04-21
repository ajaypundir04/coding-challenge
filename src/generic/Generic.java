package generic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Generic {
    public static int firstUniqCharStream(String s) {
        return s.chars()
                .boxed()
                .filter(c -> s.indexOf(c) == s.lastIndexOf(c))
                .findFirst()
                .map(s::indexOf)
                .orElse(-1);
    }

    public static int countCastles(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        if (heights.length == 1) return 1;

        int castles = 0;

        for (int i = 0; i < heights.length; i++) {
            boolean isPeak = true, isValley = true;

            // Left neighbor
            if (i > 0) {
                if (heights[i] <= heights[i-1]) isPeak = false;
                if (heights[i] >= heights[i-1]) isValley = false;
            }

            // Right neighbor
            if (i < heights.length - 1) {
                if (heights[i] <= heights[i+1]) isPeak = false;
                if (heights[i] >= heights[i+1]) isValley = false;
            }

            if (isPeak || isValley) castles++;
        }

        return castles;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int write = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[write - 1]) {
                nums[write++] = nums[read];
            }
        }
        return write;
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int skip = 0;
        int take = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int prevSkip = skip;
            skip = Math.max(skip, take);
            take = prevSkip + nums[i];
        }

        return Math.max(skip, take);
    }

    public static int numRollsToTarget(int n, int k, int target) {
        if (n * k < target || target < n) return 0;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        int MOD = 1_000_000_007;

        for (int i = 1; i <= n; i++) {
            int[] newDp = new int[target + 1];
            for (int j = i; j <= Math.min(target, i * k); j++) {
                for (int f = 1; f <= Math.min(k, j); f++) {
                    newDp[j] = (newDp[j] + dp[j - f]) % MOD;
                }
            }
            dp = newDp;
        }

        return dp[target];
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int coinChange2(int[] coins, int amount) {
        if (amount < 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // acts like "infinity"
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static int findLargestDigit(String numStr) {
        int maxDigit = 0;
        for (char c : numStr.toCharArray()) {
            if (!Character.isDigit(c)) throw new IllegalArgumentException("Non-digit found");
            maxDigit = Math.max(maxDigit, c - '0');
        }
        return maxDigit;
    }

    public static void main(String[] args) {
        // firstUniqCharStream
        System.out.println("firstUniqCharStream:");
        System.out.println(firstUniqCharStream("hheeloo")); // Expected: 4 (first 'l')
        System.out.println(firstUniqCharStream("aabb"));    // Expected: -1

        // countCastles
        System.out.println("\ncountCastles:");
        System.out.println(countCastles(new int[]{2, 1, 3, 2})); // Expected: 4 (each peak/valley)
        System.out.println(countCastles(new int[]{5, 5, 5}));    // Expected: 0

        // removeDuplicates
        System.out.println("\nremoveDuplicates:");
        int[] dupArray = {1, 1, 2, 2, 3};
        int len = removeDuplicates(dupArray);
        System.out.println("New length: " + len); // Expected: 3
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOf(dupArray, len))); // [1, 2, 3]

        // rob
        System.out.println("\nrob:");
        System.out.println(rob(new int[]{2, 7, 9, 3, 1})); // Expected: 12
        System.out.println(rob(new int[]{1, 2, 3, 1}));    // Expected: 4

        // numRollsToTarget
        System.out.println("\nnumRollsToTarget:");
        System.out.println(numRollsToTarget(2, 6, 7)); // Expected: 6
        System.out.println(numRollsToTarget(1, 6, 3)); // Expected: 1

        // coinChange
        System.out.println("\ncoinChange:");
        System.out.println(new Generic().coinChange(new int[]{1, 2, 5}, 11)); // Expected: 3
        System.out.println(new Generic().coinChange(new int[]{2}, 3));        // Expected: -1

        // twoSum
        System.out.println("\ntwoSum:");
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // Expected: [0, 1]

        // findLargestDigit
        System.out.println("\nfindLargestDigit:");
        System.out.println(findLargestDigit("538291")); // Expected: 9
        try {
            System.out.println(findLargestDigit("12a45")); // Should throw exception
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Expected: Non-digit found
        }
    }
}
