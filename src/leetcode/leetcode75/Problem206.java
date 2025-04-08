
import leetcode.data_structures.ListNode;


public class Problem206 {

    public static final Solution solution = new Solution();

    public static class Solution {

        public ListNode reverseList(ListNode head) {
            if (head == null) return null;
            
            ListNode prev = null, curr = head, after = head;
            while (curr != null) {
                 after = after.next;
                 curr.next = prev;
                 prev = curr;
                 curr = after;
            }
            
            return prev;
        }
        
        private ListNode reverseListRecursive(ListNode head) {
            return reverseListRecursive(null, head, head);
        }
        
        private ListNode reverseListRecursive(ListNode prev, ListNode curr, ListNode after) {
            if (curr == null) return prev;
            else {
                after = after.next;
                curr.next = prev;
                return reverseListRecursive(curr, after, after);
            }
        }
    }

    public static void main(String[] args) {
        // Test cases go here
    }
}
