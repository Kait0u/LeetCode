/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcode.data_structures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author jjaws
 */
public class TreeNode {

    public int val;
    public TreeNode left, right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this(val);
        this.left = left;
        this.right = right;
    }

    public List<Integer> toValuesList() {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(this);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr != null) {
                result.add(curr.val);
                q.offer(curr.left);
                q.offer(curr.right);
            } else {
                result.add(null);
            }
        }

        // Optional: Trim trailing nulls for cleaner output
        int i = result.size() - 1;
        while (i >= 0 && result.get(i) == null) {
            result.remove(i--);
        }

        return result;
    }

    public static TreeNode fromValues(Integer... values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        for (int idx = 1; idx < values.length;) {
            TreeNode currNode = nodeQueue.poll();

            if (idx < values.length && values[idx] != null) {
                currNode.left = new TreeNode(values[idx]);
                nodeQueue.offer(currNode.left);
            }
            ++idx;

            if (idx < values.length && values[idx] != null) {
                currNode.right = new TreeNode(values[idx]);
                nodeQueue.offer(currNode.right);
            }
            ++idx;
        }

        return root;
    }

    @Override
    public String toString() {
        return String.format("[%d]", val);
    }
}
