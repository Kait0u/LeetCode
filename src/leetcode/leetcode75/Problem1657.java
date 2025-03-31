
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Problem1657 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public boolean closeStrings(String word1, String word2) {
            /*
                Operation 1 tells us: order does not matter
            
                Operation 2 tells us: 
                the two words need to have the same repetition counts, 
                but it does not matter for which characters
            */
            
            char[] charsW1 = word1.toCharArray();
            char[] charsW2 = word2.toCharArray();
            
            Map<Character, Integer> charFrequencyMapW1, charFrequencyMapW2;
            Set<Character> charSetW1, charSetW2;
            
            charFrequencyMapW1 = getFrequencies(charsW1);
            charSetW1 = charFrequencyMapW1.keySet();
            
            charFrequencyMapW2 = getFrequencies(charsW2);
            charSetW2 = charFrequencyMapW2.keySet();
            
            
            if (!charSetW1.equals(charSetW2))
                return false;
            
            if (!charFrequencyMapW1.keySet().equals(charFrequencyMapW2.keySet()))
                return false;
            
            Map<Integer, Integer> frequencyFrequencyMapW1 
                    = getFrequencyFrequency(new ArrayList<>(charFrequencyMapW1.values()));
            Map<Integer, Integer> frequencyFrequencyMapW2 
                    = getFrequencyFrequency(new ArrayList<>(charFrequencyMapW2.values()));
            
            return frequencyFrequencyMapW1.equals(frequencyFrequencyMapW2);
        }
        
        private HashMap<Character, Integer> getFrequencies(char[] word) {
            HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
            for (Character ch : word) {
                charFrequencyMap.put(
                        ch, charFrequencyMap.getOrDefault(ch, 0) + 1
                );
            }
            return charFrequencyMap;
        }
        
        private HashMap<Integer, Integer> getFrequencyFrequency(List<Integer> frequencies) {
            HashMap<Integer, Integer> result = new HashMap<>();
            for (Integer freq : frequencies) {
                result.put(freq, result.getOrDefault(freq, 0) + 1);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        String word1, word2;
        
        word1 = "abc";
        word2 = "bca";
        System.out.println(true == solution.closeStrings(word1, word2));
        
        word1 = "a";
        word2 = "aa";
        System.out.println(false == solution.closeStrings(word1, word2));
        
        word1 = "cabbba";
        word2 = "abbccc";
        System.out.println(true == solution.closeStrings(word1, word2));
    }
}
