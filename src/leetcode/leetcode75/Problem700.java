package leetcode.leetcode75;

import leetcode.data_structures.TreeNode;

public class Problem700 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public TreeNode searchBST(TreeNode root, int val) {
            TreeNode currNode = root;
            
            while (currNode != null) {
                if (currNode.val == val) return currNode;
                
                if (val < currNode.val) 
                    currNode = currNode.left;
                else
                    currNode = currNode.right;
            }
            
            return null;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        TreeNode root = TreeNode.fromValues(4,2,7,1,3);
        int target = 2;
        System.out.println(solution.searchBST(root, target).toValuesList());
        
        root = TreeNode.fromValues(4,2,7,1,3);
        target = 5;
        System.out.println(solution.searchBST(root, target).toValuesList());
        
    }
}
