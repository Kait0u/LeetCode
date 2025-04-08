package leetcode.uncategorized;

import leetcode.data_structures.TreeNode;


public class Problem226 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public TreeNode invertTree(TreeNode root) {
            if (root == null ||isLeaf(root)) return root;
            
            TreeNode origLeft = root.left;
            TreeNode origRight = root.right;
            
            root.left = invertTree(origRight);
            root.right = invertTree(origLeft);
            
            return root;
        }
        
        private boolean isLeaf(TreeNode node) {
            return node.left == node.right && node.left == null;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        
        TreeNode root = TreeNode.fromValues(4,2,7,1,3,6,9);
        System.out.println(solution.invertTree(root).toValuesList());
        
        root = TreeNode.fromValues(2,1,3);
        System.out.println(solution.invertTree(root).toValuesList());
        
        root = TreeNode.fromValues(null);
        System.out.println(solution.invertTree(root).toValuesList());
    }
}
