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
public class Problem283 {

    private static final Solution solution = new Solution();

    static class Solution {

        public void moveZeroes(int[] nums) {
            int left = 0;
            
            for (int right = 0; right < nums.length; ++right) {
                if (nums[right] != 0) {
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left++] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums) + " " + Arrays.equals(nums, new int[] {1,3,12,0,0}));
        
        nums = new int[] {2, 1};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums) + " " + Arrays.equals(nums, new int[] {2, 1}));
    }
}

