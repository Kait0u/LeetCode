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
public class Problem238 {

    static class Solution {

        public int[] productExceptSelf(int[] nums) {
            final int numCount = nums.length;
            int[] lProducts = new int[numCount];
            int[] rProducts = new int[numCount];
            int[] result = new int[numCount];
            
            for (int l = 0, r = numCount - 1; l < numCount && r >= 0; ++l, --r) {
                lProducts[l] = nums[l] * arrGetOr(lProducts, l - 1, 1);
                rProducts[r] = nums[r] * arrGetOr(rProducts, r + 1, 1);
            }
            
            for (int idx = 0; idx < numCount; ++idx) {
                int left = arrGetOr(lProducts, idx - 1, 1);
                int right = arrGetOr(rProducts, idx + 1, 1);
                result[idx] = left * right;
            }
            
            return result;
        }
        
        public int arrGetOr(int[] arr, int idx, int fallback) {
            return (0 <= idx && idx < arr.length ? arr[idx] : fallback); 
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.equals(solution.productExceptSelf(new int[] {1,2,3,4}), new int[] {24,12,8,6}));
    }

}
