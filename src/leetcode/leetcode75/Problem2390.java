
import java.util.ArrayDeque;
import java.util.Deque;


public class Problem2390 {

    public static final Solution solution = new Solution();

    public static class Solution {
        private static final Character STAR = '*';

        // Implement your solution here
        public String removeStars(String s) {
            Deque<Character> stringStack = stringToStack(s);
            StringBuilder result = new StringBuilder();
            
            int charsToDelete = 0;
            while (!stringStack.isEmpty()) {
                Character currChar = stringStack.pop();
                
                if (currChar.equals(STAR)) {
                    ++charsToDelete;
                } else if (charsToDelete == 0) {
                    result.append(currChar);
                } else {
                    --charsToDelete;
                }
            }
            
            return result.reverse().toString();
        }
        
        private static Deque<Character> stringToStack(String s) {
            final int sLength = s.length();
            Deque<Character> result = new ArrayDeque<>(sLength);
            
            for (int idx = 0; idx < sLength; ++idx) {
                result.push(s.charAt(idx));
            }
            
            return result;
       }
    }

    public static void main(String[] args) {
        // Test cases go here
        String s = "leet**cod*e";
        System.out.println("lecoe".equals(solution.removeStars(s)));
        
        s = "erase*****";
        System.out.println("".equals(solution.removeStars(s)));
        
    }
}
