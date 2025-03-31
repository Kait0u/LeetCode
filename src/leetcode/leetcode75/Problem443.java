/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcode.leetcode75;

/**
 *
 * @author jjaws
 */
public class Problem443 {
    private static final Solution solution = new Solution();
    static class Solution {

        public int compress(char[] chars) {
            int charCount = chars.length;
            char currChar = 0;
            int count = 0;
            
            int resultLength = 0;
            
            for (int idx = 0; idx < charCount; ++idx) {
                char c = chars[idx];
                
                if (c == currChar) {
                    ++count;
                } else {
                    String s = compressSequence(currChar, count);
                    writeToArray(chars, resultLength, s.toCharArray());
                    resultLength += s.length();
                    
                    currChar = c;
                    count = 1;
                }
                
                if (idx == charCount - 1) {
                    String s = compressSequence(currChar, count);
                    writeToArray(chars, resultLength, s.toCharArray());
                    resultLength += s.length();
                }
            }
            
            return resultLength;
        }
        
                
        private static String compressSequence(char ch, int count) {
            if (count == 0) return "";
            if (count == 1) return String.valueOf(ch);
            else return String.valueOf(ch) + count;
        }
        
        private static void writeToArray(char[] arr, int fromIdx, char... items) {
            int itemCount = items.length;
            
            for (int idx = 0; idx + fromIdx < arr.length && idx < itemCount; ++idx) {
                arr[fromIdx + idx] = items[idx];
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(
                6 == solution.compress(new char[]{'a','a','b','b','c','c','c'})
        );
        System.out.println(
                1 == solution.compress(new char[]{'a'})
        );
        System.out.println(
                4 == solution.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'})
        );
    }
}
