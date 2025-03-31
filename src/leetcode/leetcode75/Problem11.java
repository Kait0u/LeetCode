/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcode.leetcode75;

import java.util.Arrays;

/**
 *
 * @author jjaws
 */
public class Problem11 {

    private static final Solution solution = new Solution();

    static class Solution {

        public int maxArea(int[] height) {
            int maxResult = 0;
            
            int left = 0;
            int right = height.length - 1;
            
            while (left < right) {
                int leftHeight = height[left];
                int rightHeight = height[right];
                int area = rectArea(spaceBetween(left, right), Math.min(leftHeight, rightHeight));
                maxResult = Math.max(area, maxResult);
               
                
                if (leftHeight < rightHeight) {
                    ++left;
                } else --right;
                
            }
            return maxResult;
        }
        
        private int rectArea(int w, int h) {
            return w * h;
        }
        
        private int spaceBetween(int left, int right) {
            return right - left;
        }
    }

    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(49 == solution.maxArea(height));
        height = new int[] {1,1};
        System.out.println(1 == solution.maxArea(height));
        height = new int[] {1,2,3,1000,9};
        System.out.println(9 == solution.maxArea(height));
    }
}
