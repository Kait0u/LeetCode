
import java.util.List;

public class Problem1004 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public int longestOnes(int[] nums, int k) {
            int maxOnes = 0;

            int left = 0;
            int currOnes = 0;
            int currFlipped = 0;

            for (int right = 0; right < nums.length; ++right) {
                int currVal = nums[right];

                if (currVal == 1) {
                    ++currOnes;
                } else if (currFlipped <= k) {
                    ++currOnes;
                    ++currFlipped;
                }

                while (currVal == 0 && currFlipped > k) {
                    int leftVal = nums[left++];
                    if (leftVal == 0) {
                        --currFlipped;
                    }
                    --currOnes;
                }

                maxOnes = Math.max(maxOnes, currOnes);
            }
            
            return maxOnes;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        int[] nums = List.of(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0).stream().mapToInt(Integer::intValue).toArray();
        int k = 2;
        System.out.println(6 == solution.longestOnes(nums, k));

        nums = List.of(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1).stream().mapToInt(Integer::intValue).toArray();
        k = 3;
        System.out.println(10 == solution.longestOnes(nums, k));

    }
}
