
import java.util.ArrayDeque;
import java.util.Deque;
import leetcode.data_structures.TreeNode;

public class Problem1161 {
    public static final Solution solution = new Solution();

    public static class Solution {
        // Implement your solution here
        public int maxLevelSum(TreeNode root) {
            if (root == null) return 0;
            
            int lvl = 1;
            long maxSum = root.val;
            
            Deque<TreeNode> nodeQueue = new ArrayDeque<>() {{
                add(root);
            }};
            
            for (int currLvl = 1; !nodeQueue.isEmpty(); ++currLvl) {
                Deque<TreeNode> levelQueue = new ArrayDeque<>();
                while (!nodeQueue.isEmpty())
                    levelQueue.add(nodeQueue.poll());
                
                long sum = 0;
                while (!levelQueue.isEmpty()) {
                    TreeNode currNode = levelQueue.poll();
                    sum += currNode.val;
                    if (currNode.left != null) nodeQueue.add(currNode.left);
                    if (currNode.right != null) nodeQueue.add(currNode.right);
                }
                
                if (sum > maxSum) {
                    lvl = currLvl;
                    maxSum = sum;
                }
            }
            return lvl;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        TreeNode root = TreeNode.fromValues(1,7,0,7,-8,null,null);
        System.out.println(solution.maxLevelSum(root));
        
        root = TreeNode.fromValues(989,null,10250,98693,-89388,null,null,null,-32127);
        System.out.println(solution.maxLevelSum(root));        
    }
}
