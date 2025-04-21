Here’s a rundown of the **core algorithmic patterns** illustrated by your solutions—each one is a reusable “trick” you can pull out in interviews when you recognize the right scenario.

---

## 1. Two‑Pointers / Reversal Pattern
- **When to use**: You need to process an array (or string) from both ends inward, or reverse/rotate in place.
- **Key idea**: Maintain two indices (`left`, `right`) that move toward each other (or wrap around) while you swap, compare, or accumulate.
- **Examples**:
    - **`rotate()`**: reverse whole array, then reverse subarrays.
    - **`maxArea()`**: move the shorter end inward to potentially increase area.
    - **`minIterationsToReverse()`**: swap mismatched characters toward the center.

---

## 2. Sliding‑Window
- **When to use**: You need to compute something over every contiguous subarray (or substring) of size *k*, or find maximum/minimum/longest substring under some constraint.
- **Key idea**: Maintain a window defined by two pointers (`start`, `end`) and adjust it as you scan. Use auxiliary structures (set, deque, map) to keep track of what’s inside the window.
- **Examples**:
    - **`lengthOfLongestSubstring()`**: expand/shrink window to keep all unique chars.
    - **`maxSlidingWindow()`**: use a *monotonic deque* to keep indices of potential maximums.

---

## 3. Heap (PriorityQueue)
- **When to use**: You need the *k* largest or smallest elements, or you want to merge sorted streams efficiently.
- **Key idea**: Maintain a min‑heap of size *k* (for kth largest) or max‑heap (for smallest), inserting and ejecting to keep only the top elements.
- **Examples**:
    - **`nthLargest()`**, **`findKthLargest()`**, **`topKFrequent()`**.

---

## 4. Hashing (Map/Set)
- **When to use**: You need O(1) lookups for complements, groupings, or frequency counts.
- **Key idea**: Use a `HashMap`/`HashSet` to record counts, last‑seen indices, or group keys.
- **Examples**:
    - **`twoSum()`**: map from number → index.
    - **`subarraySum()`** (prefix sums): map from cumulative sum → # of occurrences.
    - **`groupAnagrams()`**: map sorted‑string → list of anagrams.
    - **`validPairs()`**: set to find complement pairs.

---

## 5. Backtracking / DFS Enumeration
- **When to use**: You need *all* combinations/permutations/configurations that satisfy a constraint (sum, structure).
- **Key idea**: Recursively build partial solutions, “choose” an option, recurse, then “unchoose” (backtrack).
- **Examples**:
    - **`combinationSum()`**, **`combine()`**: choose candidates until target is reached.
    - **`generateParenthesis()`**: build valid sequences by tracking `open` and `close` counts.
    - **`inorderTraversal()`**: use an explicit stack (iterative DFS).

---

## 6. Dynamic Programming
- **When to use**: Overlapping subproblems where the optimal solution can be built from previously computed smaller solutions.
- **Key idea**: Define `dp[state]` or `dp[i][j]`, fill from base cases upward.
- **Examples**:
    - **1D DP / Kadane’s**: `maxSubArray()` tracks best ending here.
    - **1D knapsack (rolling array)**: `maximizeProfit()` for delivery uses reverse-iteration to reuse space.
    - **2D knapsack**: `knapsack()` builds a table of weights × items.
    - **Product Except Self**: prefix/postfix products.

---

## 7. Greedy
- **When to use**: Local optimal choices lead to global optimum, and there’s a provable strategy based on sorting or simple heuristics.
- **Key idea**: Sort or scan, make the “best” immediate choice, never look back.
- **Examples**:
    - **`maxProfit()`** (single‑transaction stock): always buy at the lowest seen, sell at current if profitable.
    - **`castles()`**: count peaks/valleys in one scan; no need for complex structure.

---

## 8. Cycle Detection (Floyd’s Tortoise & Hare)
- **When to use**: You suspect a “linked” structure (array interpreted as pointers) contains a cycle and you want to find the entry point.
- **Key idea**: Advance two pointers at different speeds; their meeting implies a cycle.
- **Examples**:
    - **`findDuplicate()`**: treat indexes/values as nodes/edges to detect the duplicate.

---

## 9. Divide & Conquer / Binary Search
- **When to use**: You need to split the problem in half repeatedly, or find a partition point in a sorted structure.
- **Key idea**: Repeatedly halve the search space or partition indices.
- **Examples**:
    - **`findMedianSortedArrays()`**: binary‑search the correct partition in the smaller array.
    - **`search()`** in rotated array: modified binary search on two sorted halves.

---

## 10. Monotonic Queue / Deque
- **When to use**: Sliding-window maximum/minimum where you need to eject old indices and maintain a sorted order of candidates.
- **Key idea**: Keep indices in a deque such that values are in decreasing order; front is the max.
- **Examples**:
    - **`maxSlidingWindow()`**.

---

### **Memorization Tips**
- **Match pattern to problem**: As you read a prompt, ask “Is this a sliding-window? two‑pointers? greedy?”
- **Keyword triggers**:
    - *subarray/substring* + fixed size → sliding window
    - *kth largest*, *top k* → heap
    - *all combinations*, *sum equals* → backtracking
    - *maximum profit*, *capacity*, *items* → knapsack DP
    - *sorted arrays*, *median*, *search* → binary search
- **Practice**: Solve one problem from each pattern family every day until the approach becomes second-nature.

