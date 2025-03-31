
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Problem1207 {

    public static final Solution solution = new Solution();

    public static class Solution {
        // Implement your solution here
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> intToCountMap = new HashMap<>();
            
            for (int x: arr) {
                intToCountMap.put(x, 1 + intToCountMap.getOrDefault(x, 0));
            }
            
            Set<Integer> keys = intToCountMap.keySet();
            Set<Integer> occurrences = new HashSet<>(intToCountMap.values());
            
            return keys.size() == occurrences.size();
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        int[] arr = new int[] {1,2,2,1,1,3};
        System.out.println(true == solution.uniqueOccurrences(arr));
        arr = new int[] {1,2};
        System.out.println(false == solution.uniqueOccurrences(arr));
        arr = new int[] {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(true == solution.uniqueOccurrences(arr));
    }
}
