package leetcode.uncategorized;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem3375 {

    public static final Solution solution = new Solution();

    public static class Solution {

        // Implement your solution here
        public int minOperations(int[] nums, int k) {
            Set<Integer> ints = new HashSet<>();
            int count = 0;
            for (int num : nums) {
                if (num < k) {
                    return -1;
                }

                if (!ints.contains(num)) {
                    ints.add(num);
                    if (num > k) {
                        ++count;
                    }
                }
            }
            
            return count;
        }
        public int minOperations3(int[] nums, int k) {
            Map<Integer, Integer> intCount = new HashMap<>();

            for (int num : nums) {
                if (num < k) {
                    return -1;
                }

                intCount.put(num, 1 + intCount.getOrDefault(num, 0));
            }

            final int numCount = nums.length;
            int ops = 0;

            while (intCount.getOrDefault(k, 0) != numCount) {
                int[] availableInts = setToIntArray(intCount.keySet());
                int h = 0;
                if (availableInts.length > 1) {
                    int[] topTwo = findTwoHighest(availableInts);
                    int maxInt = topTwo[0];
                    h = topTwo[1]; // h
                    intCount.put(
                            h,
                            intCount.get(maxInt) + intCount.getOrDefault(h, 0)
                    );
                    intCount.remove(maxInt);

                } else {
                    h = k;
                    for (int num : availableInts) {
                        if (num > h) {
                            intCount.put(
                                    h,
                                    intCount.get(num) + intCount.getOrDefault(h, 0)
                            );
                            intCount.remove(num);
                        }
                    }
                }

                ++ops;
            }

            return ops;
        }

        private int[] setToIntArray(Set<Integer> c) {
            return c.stream().mapToInt(Integer::intValue).toArray();
        }

        private int[] findTwoHighest(int[] nums) {
            int[] results = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};

            for (int num : nums) {
                if (num > results[0]) {
                    results[1] = results[0];
                    results[0] = num;
                } else if (num > results[1]) {
                    results[1] = num;
                }
            }

            return results;
        }
    }

    public static void main(String[] args) {
        // Test cases go here

        int[] nums = new int[]{5, 2, 5, 4, 5};
        int k = 2;
        System.out.println(solution.minOperations(nums, k));

        nums = new int[]{2, 1, 2};
        k = 2;
        System.out.println(solution.minOperations(nums, k));

        nums = new int[]{9, 7, 5, 3};
        k = 1;
        System.out.println(solution.minOperations(nums, k));
    }
}
