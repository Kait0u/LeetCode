
public class Problem1732 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public int largestAltitude(int[] gain) {
            int maxAlt = 0;
            int currAlt = 0;
            
            for (int gainVal : gain) {
                currAlt += gainVal;
                maxAlt = Math.max(maxAlt, currAlt);
            }

            return maxAlt;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        int[] gain = new int[] {-5,1,5,0,-7};
        System.out.println(1 == solution.largestAltitude(gain));
        
        gain = new int[] {-4,-3,-2,-1,4,3,2};
        System.out.println(0 == solution.largestAltitude(gain));
    }
}
