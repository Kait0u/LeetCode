
import java.util.ArrayDeque;
import java.util.Deque;
import leetcode.data_structures.ListNode;


public class Problem2130 {

    public static final Solution solution = new Solution();


    public static class Solution {

        // Implement your solution here
        public int pairSum(ListNode head) {
            Deque<ListNode> secondHalfStack = getSecondHalfStack(head);
            int maxSum = Integer.MIN_VALUE;
            
            while (!secondHalfStack.isEmpty()) {
                int leftVal = head.val;
                int rightVal = secondHalfStack.pollLast().val;
                maxSum = Math.max(leftVal + rightVal, maxSum);
                head = head.next;
            }
            
            return maxSum;
        }
        
        private ListNode findMiddle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            
            return slow;
        }
        
        private Deque<ListNode> getSecondHalfStack(ListNode head) {
            Deque<ListNode> result = new ArrayDeque<>();
            ListNode middle = findMiddle(head);
            
            while (middle != null) {
                result.addLast(middle);
                middle = middle.next;
            }
            
            return result;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(5);
        
        System.out.println(solution.pairSum(head));
    }
}
