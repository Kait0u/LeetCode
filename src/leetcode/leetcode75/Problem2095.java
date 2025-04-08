
import leetcode.data_structures.ListNode;


public class Problem2095 {

    public static final Solution solution = new Solution();


    public static class Solution {

        // Implement your solution here
        public ListNode deleteMiddle(ListNode head) {
            ListNode prevSlow = head;
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                prevSlow = slow;
                slow = slow.next;

                if (fast.next != null) {
                    fast = fast.next;
                } else {
                    break;
                }

                if (fast.next != null) {
                    fast = fast.next;
                } else {
                    break;
                }
            }

            if (slow == head) {
                return null;
            } else {
                ListNode left = prevSlow;
                ListNode right = slow.next;

                left.next = right;

                return head;
            }
        }
    }

    public static void main(String[] args) {
        // Test cases go here
    }
}
