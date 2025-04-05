
import java.util.ArrayDeque;
import java.util.Deque;


public class Problem933 {
    public static final Solution solution = new Solution();

    public static class Solution {
        // Implement your solution here
        public static class RecentCounter {
            private static final int MEMORY_PERIOD = 3000;
            Deque<Integer> times;

            public RecentCounter() {
                times = new ArrayDeque<>();
            }

            public int ping(int t) {
                times.addLast(t);
                
                while (!isInInclRange(times.peekFirst(), t - MEMORY_PERIOD, t)) {
                    times.pollFirst();
                }
                
                return times.size();
            }
            
            private boolean isInInclRange(int val, int fromInc, int toInc) {
                return fromInc <= val && val <= toInc;
            }
        }
    }
        

    public static void main(String[] args) {
        // Test cases go here
        Solution.RecentCounter recentCounter = new Solution.RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}
