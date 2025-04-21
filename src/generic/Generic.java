package generic;

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


    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int skip = 0; // Max sum if we skip current house
        int take = nums[0]; // Max sum if we take current house

        for (int i = 1; i < nums.length; i++) {
            int prevSkip = skip;
            skip = Math.max(skip, take); // Skip current, keep best of prior skip/take
            take = prevSkip + nums[i];   // Take current, add to prior skip
        }

        return Math.max(skip, take); // Best of final skip or take
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


    public static void main(String[] args) {
        System.out.println(firstUniqCharStream("hheeloo"));
        System.out.println(countCastles(new int[]{2,1,3,2}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(numRollsToTarget(2,6,11));
    }

}
