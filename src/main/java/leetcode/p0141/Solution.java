package leetcode.p0141;

import java.util.HashSet;

/**
 * Problem 141: Linked List Cycle
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/linked-list-cycle/
 *
 * Description:
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached
 * again by continuously following the next pointer. Internally, pos is used to denote the
 * index of the node that tail's next pointer is connected to. Note that pos is not passed
 * as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class Solution {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        // TODO: Implement your solution here
        HashSet<ListNode> visited = new HashSet<>();
        while(head!=null){
            if(visited.contains(head)){
                return true;
            } else {
                visited.add(head);
                head = head.next;
            }
        }
        return false;

        // if(head==null || head.next==null){
        //     return false;
        // }

        // ListNode fast = head;
        // ListNode slow = head;

        // while(fast != null && fast.next != null){
        //     fast = fast.next.next;
        //     slow = slow.next;
        //     if(fast == slow){
        //         return true;
        //     }

        // }
        // return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: [3,2,0,-4] with cycle at position 1
        ListNode test1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        test1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates cycle
        System.out.println("Test 1 (has cycle): " + solution.hasCycle(test1) + " (Expected: true)");

        // Test case 2: [1,2] with cycle at position 0
        ListNode test2 = new ListNode(1);
        ListNode node2b = new ListNode(2);
        test2.next = node2b;
        node2b.next = test2; // Creates cycle
        System.out.println("Test 2 (has cycle): " + solution.hasCycle(test2) + " (Expected: true)");

        // Test case 3: [1] with no cycle
        ListNode test3 = new ListNode(1);
        System.out.println("Test 3 (no cycle): " + solution.hasCycle(test3) + " (Expected: false)");
    }
}
