package leetcode.leetcode75;

import java.util.LinkedList;
import java.util.Queue;
import leetcode.data_structures.TreeNode;

public class Problem450 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            
            TreeNode currNode = root;
            TreeNode prevNode = root;
            
            while (currNode != null) {
                if (currNode.val == key) {
                    break;
                }
                
                prevNode = currNode;
                
                if (key < currNode.val) {
                    currNode = currNode.left;
                } else {
                    currNode = currNode.right;
                }
            }

            boolean isDeletionTargetRoot = currNode == root;
            boolean isDeletionTargetLeft = prevNode.left == currNode;
            
            if (currNode != null && currNode.val == key) {
                Queue<Integer> subtreeAsQueue = toList(currNode);
                subtreeAsQueue.poll(); // Get the deletion target out of the queue.

                TreeNode newSubtree = null;
                if (!subtreeAsQueue.isEmpty()) {
                    newSubtree = buildBST(
                        new TreeNode(subtreeAsQueue.poll()), subtreeAsQueue
                    );
                }

                if (isDeletionTargetRoot) {
                    root = newSubtree;
                } else if (isDeletionTargetLeft) {
                    prevNode.left = newSubtree;
                } else {
                    prevNode.right = newSubtree;
                }
            }
            
            return root;
        }
        
        private LinkedList<Integer> toList(TreeNode root) {
            LinkedList<Integer> valList = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                
                if (node != null) {
                    valList.add(node.val);
                    
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            
            return valList;
        }
        
        private TreeNode buildBST(TreeNode root, Queue<Integer> children) {
            while (!children.isEmpty()) {
                TreeNode currNode = root;
                TreeNode newChild = new TreeNode(children.poll());
                
                boolean parentAlreadyFound = false;
                while (currNode != null && !parentAlreadyFound) {
                    if (newChild.val > currNode.val) {
                        if (currNode.right == null) {
                            currNode.right = newChild;
                            parentAlreadyFound = true;
                        } else {
                            currNode = currNode.right;
                        }
                    } else {
                        if (currNode.left == null) {
                            currNode.left = newChild;
                            parentAlreadyFound = true;
                        } else {
                            currNode = currNode.left;
                        }
                    }
                }
            }
            
            return root;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        
        TreeNode root = TreeNode.fromValues(5,3,6,2,4,null,7);
        int target = 3;
        System.out.println(solution.deleteNode(root, target).toValuesList());
        
//        root = TreeNode.fromValues(5,3,6,2,4,null,7);
//        target = 0;
//        System.out.println(solution.deleteNode(root, target).toValuesList());
//        
//        root = TreeNode.fromValues(5,3,6,2,4,null,7);
//        target = 5;
//        System.out.println(solution.deleteNode(root, target).toValuesList());
//        
//        root = null;
//        target = 0;
//        System.out.println(solution.deleteNode(root, target));
//        
//        root = TreeNode.fromValues(0);
//        target = 0;
//        System.out.println(solution.deleteNode(root, target));
        
        root = TreeNode.fromValues(5,3,6,2,4,null,7);
        target = 7;
        System.out.println(solution.deleteNode(root, target).toValuesList());
    }
}
