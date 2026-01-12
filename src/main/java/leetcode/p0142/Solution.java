package leetcode.p0142;

import java.util.HashSet;

/**
 * Problem 142: Linked List Cycle II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Description:
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that can be
 * reached again by continuously following the next pointer. Internally, pos is used
 * to denote the index of the node that tail's next pointer is connected to (0-indexed).
 * It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 *
 * Do not modify the linked list.
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

    public ListNode detectCycle(ListNode head) {
        // TODO: Implement your solution here
        // do the hashset simple solution 1st
        // HashSet<ListNode> candidates = new HashSet<>();
        // ListNode currNode = head;
        // while(currNode!=null){
        //     if(candidates.contains(currNode)){
        //         return currNode;
        //     }
        //     candidates.add(currNode);
        //     currNode = currNode.next;
        // }
        // return null;

        // fast slow pointer
        // if head is null or only 1 node then no exists
        if(head==null || head.next==null){ return null;}

        ListNode slow = head;
        ListNode fast = head;

        // find meeting point first
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                //they met
                break;
            }
        }

        // when reaching here
        // either find the meeting point
        // or there is no circle
        if(fast==null || fast.next == null){
            return null;
        }

        // now they met at slow or fast (they are same node)
        // according to math, from this point if slow moves distance of k (which is from head to entry point)
        // then slow will also arrive at entry
        // we just note that meeting point
        // here it is guranteed the circle exists
        ListNode pointFromHead = head;
        ListNode pointFromSlow = slow;

        // we do not need to check if entry is head
        // if(pointFromHead == pointFromSlow ){
        //         return pointFromHead;
        // }
        
        while (pointFromHead != pointFromSlow) {
            pointFromHead = pointFromHead.next;
            pointFromSlow = pointFromSlow.next;
            // if(pointFromHead == pointFromSlow ){
            //     return pointFromHead;
            // }
        }

        // here it is gurantted the two moves now meet at entry point, no need to check
        return pointFromHead;
        // return null;
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
        node4.next = node2; // Creates cycle at position 1
        ListNode result1 = solution.detectCycle(test1);
        System.out.println("Test 1 (cycle at pos 1): " + (result1 != null ? result1.val : "null") + " (Expected: 2)");

        // Test case 2: [1,2] with cycle at position 0
        ListNode test2 = new ListNode(1);
        ListNode node2b = new ListNode(2);
        test2.next = node2b;
        node2b.next = test2; // Creates cycle at position 0
        ListNode result2 = solution.detectCycle(test2);
        System.out.println("Test 2 (cycle at pos 0): " + (result2 != null ? result2.val : "null") + " (Expected: 1)");

        // Test case 3: [1] with no cycle
        ListNode test3 = new ListNode(1);
        ListNode result3 = solution.detectCycle(test3);
        System.out.println("Test 3 (no cycle): " + (result3 != null ? result3.val : "null") + " (Expected: null)");
    }
}
