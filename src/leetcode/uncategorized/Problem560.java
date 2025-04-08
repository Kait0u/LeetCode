package leetcode.uncategorized;


import java.util.HashMap;


public class Problem560 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            int sum = 0;
            HashMap<Integer, Integer> sumCountMap = new HashMap<>();
            sumCountMap.put(0, 1);
            
            for (int idx = 0; idx < nums.length; ++idx) {
                sum += nums[idx];
                
                int diff = sum - k;
                count += sumCountMap.getOrDefault(diff, 0);
                sumCountMap.put(sum, 1 + sumCountMap.getOrDefault(sum, 0));
            }
            
            return count;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        int[] nums = new int[] {1,1,1};
        int k = 2;
        System.out.println(2 == solution.subarraySum(nums, k));
        
        nums = new int[] {1,2,3};
        k = 3;
        System.out.println(2 == solution.subarraySum(nums, k));
        
        nums = new int[] {1, -3};
        k = -1;
        System.out.println(1 == solution.subarraySum(nums, k));
    }
}
