package leetcode.p0206;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 2, time = 1)
@Measurement(iterations = 3, time = 1)
@Fork(1)
public class BenchmarkSolution {

    private Solution solution;
    private Solution.ListNode testCase1;
    private Solution.ListNode testCase2;
    private Solution.ListNode testCase3;

    @Setup
    public void setup() {
        solution = new Solution();

        // Test case 1: [1,2,3,4,5] - 5 nodes
        testCase1 = new Solution.ListNode(1,
                    new Solution.ListNode(2,
                    new Solution.ListNode(3,
                    new Solution.ListNode(4,
                    new Solution.ListNode(5)))));

        // Test case 2: [1,2] - 2 nodes
        testCase2 = new Solution.ListNode(1, new Solution.ListNode(2));

        // Test case 3: null - empty list
        testCase3 = null;
    }

    @Benchmark
    public void benchmarkReverseList_5Nodes(Blackhole bh) {
        // Clone the list for each iteration
        Solution.ListNode list = cloneList(testCase1);
        bh.consume(solution.reverseList(list));
    }

    @Benchmark
    public void benchmarkReverseList_2Nodes(Blackhole bh) {
        Solution.ListNode list = cloneList(testCase2);
        bh.consume(solution.reverseList(list));
    }

    @Benchmark
    public void benchmarkReverseList_Empty(Blackhole bh) {
        bh.consume(solution.reverseList(testCase3));
    }

    // Helper method to clone a linked list
    private Solution.ListNode cloneList(Solution.ListNode head) {
        if (head == null) return null;
        Solution.ListNode newHead = new Solution.ListNode(head.val);
        Solution.ListNode current = newHead;
        Solution.ListNode original = head.next;
        while (original != null) {
            current.next = new Solution.ListNode(original.val);
            current = current.next;
            original = original.next;
        }
        return newHead;
    }
}
