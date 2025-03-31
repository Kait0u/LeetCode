/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcode.leetcode75;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jjaws
 */
public class Problem1431 {

    static class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            List<Boolean> result = new LinkedList<>();
            int maxCandies = -1;
            for (int c: candies) {
                maxCandies = Math.max(maxCandies, c);
                
                if (c + extraCandies < maxCandies) {
                    result.add(Boolean.FALSE);
                } else {
                    result.add(null);
                }
            }
            
            for (int idx = 0; idx < candies.length; ++idx) {
                if (result.get(idx) == null) {
                    result.set(idx, candies[idx] + extraCandies >= maxCandies);
                }
            }
            
            return result;
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candies;
        int extraCandies;
        
        candies = new int[] {2,3,5,1,3}; extraCandies = 3;
        System.out.println(
                solution.kidsWithCandies(candies, extraCandies)
                        .equals(List.of(true,true,true,false,true))
        );
        
        
        
    }

}
