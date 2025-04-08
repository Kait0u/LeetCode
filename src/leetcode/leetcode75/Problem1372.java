
import java.util.ArrayDeque;
import java.util.Deque;
import leetcode.data_structures.TreeNode;


public class Problem1372 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public int longestZigZag(TreeNode root) {
            int maxZigZag = 0;
            
            Deque<TreeNode> nodeStack = new ArrayDeque<>();
            nodeStack.addLast(root);
            
            while (!nodeStack.isEmpty()) {
                TreeNode currNode = nodeStack.pollLast();
                
                if (currNode.right != null) nodeStack.addLast(currNode.right);
                if (currNode.left != null) nodeStack.addLast(currNode.left);
                
                maxZigZag = Math.max(maxZigZag, goLeft(currNode, -1));
                maxZigZag = Math.max(maxZigZag, goRight(currNode, -1));
            }
            
            return maxZigZag;
        }
        
        private int goLeft(TreeNode node, int counter) {
            if (node == null) return counter;
            
            return goRight(node.left, counter + 1);
        }
        
        private int goRight(TreeNode node, int counter) {
            if (node == null) return counter;
            
            return goLeft(node.right, counter + 1);
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        TreeNode root = TreeNode.fromValues(1);
        System.out.println(solution.longestZigZag(root));
        
        root = TreeNode.fromValues(1,null,1,1,1,null,null,1,1,null,1,null,null,null,1);
        System.out.println(solution.longestZigZag(root));
        
        root = TreeNode.fromValues(1,1,1,null,1,null,null,1,1,null,1);
        System.out.println(solution.longestZigZag(root));
    }
}
