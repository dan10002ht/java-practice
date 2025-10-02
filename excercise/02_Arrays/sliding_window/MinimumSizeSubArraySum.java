// Given an array of positive integers nums and a positive integer target,
// return the minimal length of a subarray whose sum is greater than or equal to
// target. If there is no such subarray, return 0 instead.

// Example 1:

// Input: target = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: The subarray [4,3] has the minimal length under the problem
// constraint.
// Example 2:

// Input: target = 4, nums = [1,4,4]
// Output: 1
// Example 3:

// Input: target = 11, nums = [1,1,1,1,1,1,1,1]
// Output: 0

// Constraints:

// 1 <= target <= 109
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 104

public class MinimumSizeSubArraySum {
    public int minimumSizeSubArraySum(int target, int[] nums) {
        int minimumSize = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // Khi sum >= target, ta cố gắng thu nhỏ window từ bên trái
            while (sum >= target) {
                minimumSize = Math.min(minimumSize, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minimumSize == Integer.MAX_VALUE ? 0 : minimumSize;
    }
}