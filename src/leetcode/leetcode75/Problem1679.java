/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcode.leetcode75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author jjaws
 */
public class Problem1679 {

    private static final Solution solution = new Solution();

    static class Solution {

        public int maxOperations(int[] nums, int k) {
            final int numCount = nums.length;
            int opCount = 0;
            
            HashMap<Integer, Integer> counter = new HashMap<>();
            
            boolean[] forbidden = new boolean[numCount];
            
            for (int idx = 0; idx < numCount; ++idx) {
                int val = nums[idx];
                int valCount = counter.getOrDefault(val, 0) + 1;
                counter.put(val, valCount);
            }
            
            Iterator<Integer> iter = counter.keySet().iterator();
            
            while (iter.hasNext()) {
                int n = iter.next();
                int requiredOther = k - n;
                if (requiredOther < 0) continue;
                
                int countN = counter.get(n);
                if (n == requiredOther) {
                    opCount += countN / 2;
                } else {
                    int countOther = counter.getOrDefault(requiredOther, 0);
                    opCount += Math.min(countN, countOther);
                }
                
                iter.remove();
            }
            
            System.out.println(opCount);
            return opCount;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int k = 5;
        System.out.println(2 == solution.maxOperations(nums, k));
        nums = new int[]{3, 1, 3, 4, 3};
        k = 6;
        System.out.println(1 == solution.maxOperations(nums, k));
    }
}
