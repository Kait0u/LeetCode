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
public class Problem392 {

    private static final Solution solution = new Solution();

    static class Solution {

        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0) return true;
            if (s.length() > t.length()) return false;
            
            int sIdx = 0;
            for (int tIdx = 0; tIdx < t.length(); ++tIdx) {
                if (s.charAt(sIdx) == t.charAt(tIdx)) {
                    ++sIdx;
                }
                
                if (sIdx == s.length()) return true;
            }
            
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(true == solution.isSubsequence(s, t));
        s = "axc"; t = "ahbgdc";
        System.out.println(false == solution.isSubsequence(s, t));
    }
}
