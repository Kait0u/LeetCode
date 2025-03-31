
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Problem2215 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            List<List<Integer>> answer = new ArrayList(2);
            
            Set<Integer> s1 = arrToHashSet(nums1); // Set 1, to be rid of contents of Set 2
            Set<Integer> s2 = arrToHashSet(nums2); // Set 2, to be rid of contents of Set 1
            
            Iterator<Integer> iterS1 = s1.iterator();
            
            while (iterS1.hasNext()) {
                Integer x = iterS1.next();
                
                if (s2.remove(x))
                    iterS1.remove();
            }
            
            answer.add(List.copyOf(s1));
            answer.add(List.copyOf(s2));
            
            return answer;
        }
        
        @SuppressWarnings("empty-statement")
        private HashSet<Integer> arrToHashSet(int[] arr) {
            HashSet<Integer> result = new HashSet<>();
            
            for (int idx = 0; idx < arr.length; result.add(arr[idx++]));
            
            return result;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        int[] nums1 = new int[] {1,2,3};
        int[] nums2 = new int[] {2,4,6};
        
        System.out.println(solution.findDifference(nums1, nums2));
        
        nums1 = new int[] {1,2,3, 3};
        nums2 = new int[] {1,1,2,2};
        
        System.out.println(solution.findDifference(nums1, nums2));
    }
}
