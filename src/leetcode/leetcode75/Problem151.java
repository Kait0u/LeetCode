/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leetcode.leetcode75;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jjaws
 */
public class Problem151 {

    static class Solution {
        public String reverseWords(String s) {
            Stack<String> wordStack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            
            Pattern wordPattern = Pattern.compile("\\w+");
            Matcher matcher = wordPattern.matcher(s);
            
            while (matcher.find()) {
                wordStack.push(matcher.group(0));
            }
            
            boolean firstWord = true;
            while (!wordStack.empty()) {
                if (firstWord) {
                    firstWord = false;
                } else {
                    sb.append(" ");
                }
                
                sb.append(wordStack.pop());
            }
            
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "the sky is blue";
        System.out.println(solution.reverseWords(s).equals("blue is sky the"));
    }

}
