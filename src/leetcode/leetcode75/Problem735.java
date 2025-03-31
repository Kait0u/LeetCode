
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class Problem735 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> asteroidStack = new ArrayDeque<>(asteroids.length);
            for (int idx = 0; idx < asteroids.length; ++idx) {
                int currVal = asteroids[idx];
                
                if (currVal > 0) {
                    asteroidStack.push(currVal);
                } else if (currVal < 0) {
                    int currValAbs = Math.abs(currVal);
                    
                    boolean currToBeAdded = true;
                    while (currToBeAdded && !asteroidStack.isEmpty()) {
                        int leftAsteroid = asteroidStack.pop();
                        
                        if (leftAsteroid < 0) {
                            asteroidStack.push(leftAsteroid);
                            asteroidStack.push(currVal);
                            currToBeAdded = false;
                        } else if (leftAsteroid > currValAbs) {
                            asteroidStack.push(leftAsteroid);
                            currToBeAdded = false;
                        } else if (leftAsteroid == currValAbs) {
                            currToBeAdded = false;
                        }
                    }
                    if (currToBeAdded) {
                        asteroidStack.push(currVal);
                    }   
                }
            }
            
            int remaining = asteroidStack.size();
            int[] result = new int[remaining];
            
            for (int idx = remaining - 1; !asteroidStack.isEmpty(); --idx) {
                result[idx] = asteroidStack.pop();
            }
            
            return result; 
        }
        
        
    }

    public static void main(String[] args) {
        // Test cases go here
        int[] asteroids = new int[] {5,10,-5};
        System.out.println(Arrays.equals(new int[] {5, 10}, solution.asteroidCollision(asteroids)));
        
        asteroids = new int[] {8,-8};
        System.out.println(Arrays.equals(new int[] {}, solution.asteroidCollision(asteroids)));
        
        asteroids = new int[] {10,2,-5};
        System.out.println(Arrays.equals(new int[] {10}, solution.asteroidCollision(asteroids)));
        
        asteroids = new int[] {-5, 2, 10};
        System.out.println(Arrays.equals(new int[] {-5, 2, 10}, solution.asteroidCollision(asteroids)));
        
        asteroids = new int[] {-5, 2, -10};
        System.out.println(Arrays.equals(new int[] {-5, -10}, solution.asteroidCollision(asteroids)));
        
        asteroids = new int[] {30, 20, 10, 8, -8, -10, -20, -30};
        System.out.println(Arrays.equals(new int[] {}, solution.asteroidCollision(asteroids)));
    }
}
