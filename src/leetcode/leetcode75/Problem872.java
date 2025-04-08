package leetcode.leetcode75;

import java.util.ArrayList;
import java.util.List;
import leetcode.data_structures.TreeNode;


public class Problem872 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            return getLeafValueSequence(root1)
                    .equals(getLeafValueSequence(root2));
        }
        
        private List<Integer> getLeafValueSequence(TreeNode root) {
            List<Integer> seq = new ArrayList<>();
            buildLeafValueSequence(root, seq);
            return seq;
        }
        
        private void buildLeafValueSequence(TreeNode node, List<Integer> currSeq) {
            if (node == null) return;
            
            if (isLeaf(node)) {
                currSeq.add(node.val);
            } else {
                buildLeafValueSequence(node.left, currSeq);
                buildLeafValueSequence(node.right, currSeq);
            }
        }
        
        private boolean isLeaf(TreeNode node) {
            return node.left == node.right && node.left == null;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
    }
}
