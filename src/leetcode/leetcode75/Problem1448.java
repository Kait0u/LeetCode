
import leetcode.data_structures.TreeNode;


public class Problem1448 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public int goodNodes(TreeNode root) {
            return countGoodNodes(root, root.val);
        }
        
        private int countGoodNodes(TreeNode root, int maxSoFar) {
            if (root == null) return 0;
            
            int nodeGoodness = root.val >= maxSoFar ? 1 : 0;
            maxSoFar = Math.max(root.val, maxSoFar);
            return nodeGoodness 
                    + countGoodNodes(root.left, maxSoFar)
                    + countGoodNodes(root.right, maxSoFar);
        }
    }

    public static void main(String[] args) {
        // Test cases go here
    }
}
