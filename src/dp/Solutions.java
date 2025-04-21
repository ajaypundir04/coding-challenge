package dp;

import java.util.*;

// TreeNode class for binary tree related problems
class TreeNode {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Demo {

    // ✅ Real Questions Asked at N26

    // 1. Largest Sibling of a Number
    // Rearrange digits of a number to get the largest possible number
    public int largestSibling(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        StringBuilder sb = new StringBuilder(new String(digits));
        return Integer.parseInt(sb.reverse().toString());
    }

    // 2. N-th Largest Number in Array
    // Uses min-heap to keep track of n largest elements
    public int nthLargest(int[] nums, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > n) pq.poll();
        }
        return pq.peek();
    }

    // 3. Castle on Hills
    // Count peaks and valleys in the land elevation
    public int castles(int[] land) {
        if (land == null || land.length == 0) return 0;
        int count = 1; // Always place one castle
        for (int i = 1; i < land.length - 1; i++) {
            if ((land[i] > land[i - 1] && land[i] > land[i + 1]) ||
                    (land[i] < land[i - 1] && land[i] < land[i + 1])) {
                count++;
            }
        }
        return count;
    }

    // Additional Coding Questions

    // 4. Two Sum
    // Find two indices whose elements sum up to target
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    // 5. Longest Substring Without Repeating Characters
    // Sliding window technique
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;
        for (int right = 0; right < s.length(); right++) {
            while (!set.add(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    // 6. Knapsack Problem (0/1)
    // Dynamic programming approach to solve 0/1 knapsack
    public int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }

    // 7. Minimum Number of Iterations (Infect All)
    // BFS to simulate infection spreading and count minutes
    public int minIterations(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Count fresh oranges and enqueue all rotten ones
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.add(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int time = 0;

        // BFS loop
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0], y = curr[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.add(new int[]{x, y});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }

    // 8. Combinations
    // Backtracking to generate combinations
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int n, int k, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= n; i++) {
            curr.add(i);
            backtrack(i + 1, n, k, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    // 9. Tree: Inorder Traversal
    // Iterative inorder traversal using stack
    public List<Integer> inorderTraversal(TreeNode2 root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode2> stack = new Stack<>();
        TreeNode2 curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    // 10. Graph: Detect Cycle in Undirected Graph
    // DFS based cycle detection in undirected graph
    public boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, -1, visited, adj)) return true;
        }
        return false;
    }

    private boolean dfs(int v, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, v, visited, adj)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    // Additional problems like backtracking, DP, and more graph/tree examples can be added next if you'd like.

}