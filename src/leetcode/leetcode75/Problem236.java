package leetcode.leetcode75;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import leetcode.data_structures.TreeNode;

public class Problem236 {
    public static final Solution solution = new Solution();

    public static class Solution {
        // Implement your solution here
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Deque<TreeNode> pAncestors = new ArrayDeque<>();
            Deque<TreeNode> qAncestors = new ArrayDeque<>();
            findNodeAndAncestors(root, p, pAncestors);
            findNodeAndAncestors(root, q, qAncestors);
            
            int pDepth = pAncestors.size(), qDepth = qAncestors.size();
            
            Set<TreeNode> commonAncestors = new HashSet<>();
            Deque<TreeNode> toAdd = pDepth > qDepth ? pAncestors : qAncestors;
            Deque<TreeNode> toEmpty = toAdd == pAncestors ? qAncestors : pAncestors;
            commonAncestors.addAll(toAdd);
            
            while (!toEmpty.isEmpty()) {
                TreeNode ancestor = toEmpty.pollFirst();
                if (commonAncestors.contains(ancestor)) {
                    return ancestor;
                }
            }
            
            return null;
        }
        
        private boolean findNodeAndAncestors(TreeNode currentNode, TreeNode target, Deque<TreeNode> ancestors) {
            if (currentNode == null) return false;
            if (currentNode == target) {
                ancestors.addLast(currentNode);
                return true;
            }
            
            if (findNodeAndAncestors(currentNode.left, target, ancestors) || findNodeAndAncestors(currentNode.right, target, ancestors)) {
                ancestors.addLast(currentNode);
                return true;
            }
            
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        TreeNode root = TreeNode.fromValues(3,5,1,6,2,0,8,null,null,7,4);
        TreeNode p = root.left;
        TreeNode q = root.right;
        System.out.println(solution.lowestCommonAncestor(root, p, q));
        
        root = TreeNode.fromValues(3,5,1,6,2,0,8,null,null,7,4);
        p = root.left;
        q = p.right.right;
        System.out.println(solution.lowestCommonAncestor(root, p, q));
        
        
    }
}
