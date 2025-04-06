package leetcode.leetcode75;


public class Problem328 {

    public static final Solution solution = new Solution();

    public static class ListNode {

        private int val;
        private ListNode next = null;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this(val);
            this.next = next;
        }
    }

    public static class Solution {

        // Implement your solution here
        public ListNode oddEvenList(ListNode head) {
            if (head == null) return head;
            if (head.next == null) return head;
            if (head.next.next == null) return head;
            
            ListNode newHead = new ListNode(
                    head.val, new ListNode(head.next.val)
            );
            
            ListNode odd = newHead;
            ListNode firstOdd = odd;
            ListNode even = newHead.next;
            
            ListNode originalOdd = head;
            while (originalOdd.next != null && originalOdd.next.next != null) {
                originalOdd = originalOdd.next.next;
                odd.next = new ListNode(originalOdd.val);
                odd = odd.next;
            }
            
            odd.next = even;
            
            ListNode originalEven = head.next;
            while (originalEven.next != null && originalEven.next.next != null) {
                originalEven = originalEven.next.next;
                even.next = new ListNode(originalEven.val);
                even = even.next;
            }
            
            return firstOdd;
        }
    }

    public static void main(String[] args) {
        // Test cases go here
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        
        System.out.println(solution.oddEvenList(head));
    }
}
