
import java.util.ArrayDeque;
import java.util.Deque;


public class Problem394 {

    public static final Solution solution = new Solution();

    public static class Solution {
        // Implement your solution here
        public String decodeString(String s) {
            Deque<String> stack = new ArrayDeque<>();
            
            for (int idx = 0; idx < s.length(); ++idx) {
                char ch = s.charAt(idx);
                
                if (isCloseB(ch)) {
                    // Construct the args
                    StringBuilder sb = new StringBuilder();
                    for (String stackItem = null; !stack.isEmpty(); ) {
                        stackItem = stack.pollLast();
                        
                        if (stackItem.equals("[")) {
                            break;
                        }
                        
                        sb.insert(0, stackItem);
                    }
                    
                    String strToRepeat = sb.toString();
                    
                    // Construct a number
                    sb = new StringBuilder();
                    for (String stackItem = null; !stack.isEmpty(); ) {
                        stackItem = stack.getLast();
                        
                        if (!isDigit(stackItem)) {
                            break;
                        }
                        
                        sb.insert(0, stack.pollLast());
                    }
                    
                    int repeats = Integer.parseInt(sb.toString());
                    String repeated = strToRepeat.repeat(repeats);
                    stack.addLast(repeated);
                } else {
                    stack.addLast(Character.toString(ch));
                }
                
                System.out.println(stack);
            }
            
            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.insert(0, stack.pollLast());
            }
            
            return result.toString();
        }

        
        private boolean isDigit(char ch) {
            return Character.isDigit(ch);
        }
        
        private boolean isDigit(String str) {
            return str.length() == 1 && isDigit(str.charAt(0));
        }

        private boolean isCloseB(char ch) {
            return ch == ']';
        }
    }

    public static void main(String[] args) {
        // Test cases go here
//        System.out.println(solution.decodeString("3[a]2[bc]"));
//        System.out.println(solution.decodeString("3[a2[c]]"));
//        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
        System.out.println(solution.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
