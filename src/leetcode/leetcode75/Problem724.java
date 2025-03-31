
public class Problem724 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public int pivotIndex(int[] nums) {
            int leftSum = 0;
            int rightSum = arraySum(nums);
            
            for (int idx = 0; idx < nums.length; ++idx) {
                int currVal = nums[idx];
                rightSum -= currVal;
                
                if (leftSum == rightSum)
                    return idx;
                
                leftSum += currVal;
            }

            return -1;
        }
        
        @SuppressWarnings("empty-statement")
        private static int arraySum(int[] arr) {
            int sum = 0;
            
            for (int idx = 0; idx < arr.length; sum += arr[idx++]);
            
            return sum;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        int[] nums = new int[] {1,7,3,6,5,6};
        System.out.println(3 == solution.pivotIndex(nums));
        
        nums = new int[] {1,2,3};
        System.out.println(-1 == solution.pivotIndex(nums));
        
        nums = new int[] {2,1,-1};
        System.out.println(0 == solution.pivotIndex(nums));
    }
}
