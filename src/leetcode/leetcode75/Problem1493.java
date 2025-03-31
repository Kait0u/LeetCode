
public class Problem1493 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public int longestSubarray(int[] nums) {
            int maxSubarraySize = 0;

            int left = 0;
            int currSubarraySize = 0;
            int currZeros = 0;

            for (int right = 0; right < nums.length; ++right) {
                int currVal = nums[right];

                if (currVal == 1) {
                    ++currSubarraySize;
                } else if (currZeros <= 1) {
                    ++currZeros;
                }

                // Window broken?
                if (currVal == 0) {
                    while (currZeros > 1) {
                        int leftVal = nums[left++];
                        if (leftVal == 0) {
                            --currZeros;
                        } else {
                            --currSubarraySize;
                        }
                    }
                }

                maxSubarraySize = Math.max(maxSubarraySize, currSubarraySize);
            }

            return maxSubarraySize == nums.length ? maxSubarraySize - 1 : maxSubarraySize;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        int[] nums = new int[]{1, 1, 0, 1};
        System.out.println(3 == solution.longestSubarray(nums));

        nums = new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(5 == solution.longestSubarray(nums));

        nums = new int[]{1, 1, 1};
        System.out.println(2 == solution.longestSubarray(nums));

    }
}
