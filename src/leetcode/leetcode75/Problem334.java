/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcode.leetcode75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jjaws
 */
public class Problem334 {

    private static final Solution solution = new Solution();

    static class Solution {

        public boolean increasingTriplet(int[] nums) {
            final int numCount = nums.length;

            int firstIdx = 0;
            int secondIdx = -1;

            
            for (int idx = 0; idx < numCount; ++idx) {
                int currVal = nums[idx];
                
                if (currVal <= nums[firstIdx]) {
                    firstIdx = idx;
                } else if (secondIdx < 0 || currVal <= nums[secondIdx]) {
                    secondIdx = idx;
                } else {
                    return true;
                }
            }
            
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                solution.increasingTriplet(new int[]{1, 2, 3, 4, 5}) // true
        );
        System.out.println(
                solution.increasingTriplet(new int[]{5, 4, 3, 2, 1}) // false
        );
        System.out.println(
                solution.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}) // true
        );
        System.out.println(
                solution.increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}) // true
        );
        System.out.println(
                solution.increasingTriplet(new int[]{2, 4, -2, -3}) // false
        );
    }

}
