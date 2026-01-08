package leetcode.p0206;

/**
 * Problem 206: Reverse Linked List
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reverse-linked-list/
 *
 * Description:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class Solution {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        // TODO: Implement your solution here
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: [1,2,3,4,5]
        ListNode test1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result1 = solution.reverseList(test1);
        System.out.print("Test 1: ");
        printList(result1);
        System.out.println(" (Expected: [5,4,3,2,1])");

        // Test case 2: [1,2]
        ListNode test2 = new ListNode(1, new ListNode(2));
        ListNode result2 = solution.reverseList(test2);
        System.out.print("Test 2: ");
        printList(result2);
        System.out.println(" (Expected: [2,1])");

        // Test case 3: []
        ListNode result3 = solution.reverseList(null);
        System.out.print("Test 3: ");
        printList(result3);
        System.out.println(" (Expected: [])");
    }

    private static void printList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(",");
            head = head.next;
        }
        System.out.print("]");
    }
}
