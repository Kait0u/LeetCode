
import java.util.HashSet;
import java.util.Set;


public class Problem1456 {
    public static final Solution solution = new Solution();

    public static class Solution {
        private static final Set<Character> VOWELS = new HashSet<>();
        static {
            final char[] chrs = "aiueo".toCharArray();
            for (char ch : chrs) {
                VOWELS.add(ch);
            }
        }
        
        private static boolean isVowel(char ch) {
            return VOWELS.contains(ch);
        }
        
        private static int boolToInt(boolean b) {
            return b ? 1 : 0;
        }

        // Implement your solution here
        public int maxVowels(String s, int k) {
            int maxCount = 0;
            
            int currWindowCount = 0;
            int right = 0;
            
            for (; right < k; ++right) {
                char currChar = s.charAt(right);
                
                if (isVowel(currChar))
                    ++currWindowCount;
            }
            
            maxCount = currWindowCount;
            
            int left = 0;
            for (; right < s.length(); ++right) {
                char currFrontChar = s.charAt(right);
                char currBackChar = s.charAt(left++);
                
                currWindowCount += (
                    boolToInt(isVowel(currFrontChar)) 
                        - boolToInt(isVowel(currBackChar))
                );
                
                maxCount = Math.max(maxCount, currWindowCount);
            }
            
            return maxCount;
        }
    }

    public static void main(String[] args) {
        System.out.println(3 == solution.maxVowels("abciiidef", 3));
        System.out.println(2 == solution.maxVowels("aeiou", 2));
        System.out.println(2 == solution.maxVowels("leetcode", 3));
    }
}
