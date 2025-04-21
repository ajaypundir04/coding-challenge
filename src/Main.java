import dp.AllSolutions;
import dp.MoreSolutions;
import dp.RemainingSolutions;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        testAllSolutions();
        testRemainingSolutions();
    }

    private static void assertEquals(Object expected, Object actual, String testName) {
        if (Objects.equals(expected, actual)) {
            System.out.println("[PASS] " + testName);
        } else {
            System.err.println("[FAIL] " + testName + ": expected " + expected + ", got " + actual);
        }
    }

    private static void testAllSolutions() {
        AllSolutions sol = new AllSolutions();

        assertEquals(321, sol.largestSibling(213), "largestSibling");
        assertEquals(5, sol.nthLargest(new int[]{3,2,1,5,6,4}, 2), "nthLargest");
        assertEquals(3, sol.castles(new int[]{2,4,1,3,5}), "castles");
        List<String[]> csv = sol.parseCSV(Arrays.asList("a,b,c", "1,2,3"));
        assertEquals(2, csv.size(), "parseCSV size");

        assertEquals(Arrays.toString(new int[]{0,1}), Arrays.toString(sol.twoSum(new int[]{2,7,11,15},9)), "twoSum");
        assertEquals(3, sol.lengthOfLongestSubstring("abcabcbb"), "lengthOfLongestSubstring");
        assertEquals(6, sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}), "maxSubArray");
        assertEquals(Arrays.toString(new int[]{24,12,8,6}), Arrays.toString(sol.productExceptSelf(new int[]{1,2,3,4})), "productExceptSelf");

        int[] moveZeroesArr = {0,1,0,3,12};
        sol.moveZeroes(moveZeroesArr);
        assertEquals(Arrays.toString(new int[]{1,3,12,0,0}), Arrays.toString(moveZeroesArr), "moveZeroes");

        int[][] merged = sol.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        assertEquals(Arrays.toString(new int[][]{{1,6},{8,10},{15,18}}), Arrays.toString(merged), "merge");

        assertEquals(49, sol.maxArea(new int[]{1,8,6,2,5,4,8,3,7}), "maxArea");

        int[] rotateArr = {1,2,3,4,5,6,7};
        sol.rotate(rotateArr, 3);
        assertEquals(Arrays.toString(new int[]{5,6,7,1,2,3,4}), Arrays.toString(rotateArr), "rotate");

        assertEquals(2, sol.findDuplicate(new int[]{1,3,4,2,2}), "findDuplicate");

        List<List<String>> anagrams = sol.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        assertEquals(3, anagrams.size(), "groupAnagrams");

        assertEquals(true, sol.isValid("()[]{}"), "isValid");
    }

    private static void testRemainingSolutions() {
        RemainingSolutions sol = new RemainingSolutions();

        assertEquals(Arrays.toString(new int[]{1,2}), Arrays.toString(sol.topKFrequent(new int[]{1,1,1,2,2,3}, 2)), "topKFrequent");
        assertEquals(true, sol.isIsomorphic("egg","add"), "isIsomorphic");
        assertEquals(2, sol.subarraySum(new int[]{1,1,1},2), "subarraySum");
        assertEquals(4, sol.longestConsecutive(new int[]{100,4,200,1,3,2}), "longestConsecutive");
        assertEquals(5, sol.findKthLargest(new int[]{3,2,1,5,6,4},2), "findKthLargest");
        assertEquals(4, sol.search(new int[]{4,5,6,7,0,1,2},0), "search");

        int[] range = sol.searchRange(new int[]{5,7,7,8,8,10},8);
        assertEquals(Arrays.toString(new int[]{3,4}), Arrays.toString(range), "searchRange");
        MoreSolutions sol1 = new MoreSolutions();

        assertEquals(2.0, sol1.findMedianSortedArrays(new int[]{1,3}, new int[]{2}), "findMedianSortedArrays");

        List<List<Integer>> combSum = sol1.combinationSum(new int[]{2,3,6,7},7);
        assertEquals(true, combSum.contains(Arrays.asList(7)), "combinationSum contains 7");

        List<String> parens = sol1.generateParenthesis(3);
        assertEquals(5, parens.size(), "generateParenthesis count");

        // Test MinStack
        MoreSolutions.MinStack minStack = sol1.new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin(), "MinStack getMin1");
        minStack.pop();
        assertEquals(0, minStack.top(), "MinStack top");
        assertEquals(-2, minStack.getMin(), "MinStack getMin2");

        assertEquals(Arrays.toString(new int[]{3,3,5,5,6,7}), Arrays.toString(sol1.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)), "maxSlidingWindow");

        assertEquals(2, sol1.minIterationsToReverse("abcd"), "minIterationsToReverse");
        assertEquals(5, sol1.maxProfit(new int[]{7,1,5,3,6,4}), "maxProfit");
        assertEquals(13, sol1.maximizeProfit(new int[]{1,2,3,2}, new int[]{8,4,0,5}, 4), "maximizeProfit");

        List<int[]> pairs = sol1.validPairs(new int[]{1,2,3,4,3},5);
        assertEquals(3, pairs.size(), "validPairs count");
    }
}
