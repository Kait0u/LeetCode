
import java.util.HashMap;
import java.util.Map;

public class Problem3396 {
    public static final Solution solution = new Solution();

    public static class Solution {
        // Implement your solution here
        public int minimumOperations(int[] nums) {
            int opCount = 0;
            Map<Integer, Integer> numCount = new HashMap<>();
            
            for (int num : nums)
                numCount.put(num, 1 + numCount.getOrDefault(num, 0));
            
            for (int startIdx = 0; startIdx < nums.length; startIdx += 3, ++opCount) {
                int targetUnique = nums.length - startIdx;
                int onesCount = 0;
                
                for (int num : numCount.keySet()) {
                    if (numCount.get(num) == 1) 
                        ++onesCount;
                }
                
                if (onesCount == targetUnique) {
                    return opCount;
                }
                
                for (int idx = startIdx; idx < startIdx + 3 && idx < nums.length; ++idx) {
                    int num = nums[idx];
                    numCount.put(num, numCount.get(num) - 1);
                }
            }
            
            
            return opCount;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        int[] nums = new int[] {1,2,3,4,2,3,3,5,7};
        System.out.println(2 == solution.minimumOperations(nums));
        
        nums = new int[] {4,5,6,4,4};
        System.out.println(2 == solution.minimumOperations(nums));
        
        nums = new int[] {6,7,8,9};
        System.out.println(0 == solution.minimumOperations(nums));
    }
}
