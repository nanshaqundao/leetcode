package leetcode.p0001;

/**
 * Problem 1: Two Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        // Your solution here
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: nums = [2,7,11,15], target = 9
        int[] test1 = {2, 7, 11, 15};
        int[] result1 = solution.twoSum(test1, 9);
        System.out.println("Test 1: [" + result1[0] + ", " + result1[1] + "] (Expected: [0, 1])");

        // Test case 2: nums = [3,2,4], target = 6
        int[] test2 = {3, 2, 4};
        int[] result2 = solution.twoSum(test2, 6);
        System.out.println("Test 2: [" + result2[0] + ", " + result2[1] + "] (Expected: [1, 2])");
    }
}
