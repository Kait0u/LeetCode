
import leetcode.data_structures.TreeNode;


public class Problem104 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    public static void main(String[] args) {
        // Test cases go here
    }
}
