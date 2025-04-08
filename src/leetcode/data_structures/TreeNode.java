/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcode.data_structures;

/**
 *
 * @author jjaws
 */
public class TreeNode {
    public int val;
    public TreeNode left, right;
    
    public TreeNode() {}
    
    public TreeNode(int val) { this.val = val; }
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this(val);
        this.left = left;
        this.right = right;
    }
}
