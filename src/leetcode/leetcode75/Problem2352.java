
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2352 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public int equalPairs(int[][] grid) {
            final int n = grid.length;
            int result = 0;

            Map<List<Integer>, Integer> seqMap = new HashMap<>();

            for (int colIdx = 0; colIdx < n; ++colIdx) {
                List<Integer> col = new ArrayList<>(n);
                
                for (int rowIdx = 0; rowIdx < n; ++rowIdx) {
                    col.add(grid[rowIdx][colIdx]);
                }
                
                seqMap.put(col, seqMap.getOrDefault(col, 0) + 1);
            }
            
            for (int rowIdx = 0; rowIdx < n; ++rowIdx) {
                List<Integer> row = new ArrayList<>(n);
                
                for (int colIdx = 0; colIdx < n; ++colIdx) {
                    row.add(grid[rowIdx][colIdx]);
                }
                
                result += seqMap.getOrDefault(row, 0);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        
        int[][] grid = new int[][] {
            new int[] {3,2,1},
            new int[] {1,7,6},
            new int[] {2,7,7}
        };
        
        System.out.println(1 == solution.equalPairs(grid));
        
        grid = new int[][] {
            new int[] {3,1,2,2},
            new int[] {1,4,4,5},
            new int[] {2,4,2,2},
            new int[] {2,4,2,2}
        };
        
        System.out.println(3 == solution.equalPairs(grid));
        
        grid = new int[][] {
            new int[] {3,1,2,2},
            new int[] {1,4,4,4},
            new int[] {2,4,2,2},
            new int[] {2,5,2,2}
        };
        
        System.out.println(3 == solution.equalPairs(grid));
    }
}
