import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three
 * integers in nums such that the sum is closest to target.
 * 
 * Return the sum of the three integers.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 * 
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 * 
 * 
 * Constraints:
 * 
 * 3 <= nums.length <= 500
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3)
            return 0;

        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return sum;
                }

                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }

    // public static void main(String[] args) {
    // ThreeSumClosest solution = new ThreeSumClosest();

    // // Test case 1: [-1,2,1,-4], target = 1, expected = 2
    // int[] nums1 = { -1, 2, 1, -4 };
    // System.out.println("Test 1: " + solution.threeSumClosest(nums1, 1)); //
    // Expected: 2

    // // Test case 2: [0,0,0], target = 1, expected = 0
    // int[] nums2 = { 0, 0, 0 };
    // System.out.println("Test 2: " + solution.threeSumClosest(nums2, 1)); //
    // Expected: 0
    // }
}
