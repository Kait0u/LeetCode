
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import leetcode.data_structures.TreeNode;

public class Problem199 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<Integer> result = new ArrayList<>();
            Deque<Optional<TreeNode>> nodeQueue = new ArrayDeque<>();

            nodeQueue.addFirst(Optional.ofNullable(root));

            while (!nodeQueue.isEmpty()) {
                Deque<Optional<TreeNode>> level = new ArrayDeque<>();

                while (!nodeQueue.isEmpty()) {
                    TreeNode currNode = nodeQueue.poll().orElse(null);
                    level.addLast(Optional.ofNullable(currNode));
                }

                TreeNode levelsLast = null;

                while (!level.isEmpty()) {
                    TreeNode currNode = level.poll().orElse(null);

                    if (currNode != null) {
                        levelsLast = currNode;
                        nodeQueue.addLast(Optional.ofNullable(currNode.left));
                        nodeQueue.addLast(Optional.ofNullable(currNode.right));
                    }
                }

                if (levelsLast != null) {
                    result.add(levelsLast.val);
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        TreeNode root = TreeNode.fromValues(1, 2, 3, null, 5, null, 4);
        System.out.println(solution.rightSideView(root));
        
        root = TreeNode.fromValues(1,2,3,4,null,null,null,5);
        System.out.println(solution.rightSideView(root));
        
        root = TreeNode.fromValues(1, null, 3);
        System.out.println(solution.rightSideView(root));
        
        root = TreeNode.fromValues();
        System.out.println(solution.rightSideView(root));
        
    }
}
