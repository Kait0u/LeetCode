package leetcode.leetcode75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import leetcode.data_structures.TreeNode;

public class Problem437 {

    public static final Solution solution = new Solution();

    // This was extremely weird.........
    public static class Solution {

        // Implement your solution here
        public int pathSum(TreeNode root, int sum) {
            System.out.println(String.format("pathSum(%s, %d)", root, sum));
            if (root == null) {
                return 0;
            }
            return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        private int pathSumFrom(TreeNode node, int sum) {
            System.out.println(String.format("pathSumFrom(%s, %d)", node, sum));
            if (node == null) {
                return 0;
            }
            return (node.val == sum ? 1 : 0)
                    + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
        }
    }

    public static void main(String[] args) {
        // Test cases go here

        TreeNode root = TreeNode.fromValues(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1);
        int target = 8;
        System.out.println(solution.pathSum(root, target));

        root = TreeNode.fromValues(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);
        target = 22;
        System.out.println(solution.pathSum(root, target));

        root = TreeNode.fromValues(1, -2, -3);
        target = -1;
        System.out.println(solution.pathSum(root, target));

        root = TreeNode.fromValues(1, -2, -3, 1, 3, -2, null, -1);
        target = 2;
        System.out.println(solution.pathSum(root, target));
    }
}
