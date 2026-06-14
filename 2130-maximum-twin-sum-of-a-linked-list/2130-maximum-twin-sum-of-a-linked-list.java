class Solution {
    public int pairSum(ListNode head) {

        // STEP 1: Find middle of linked list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // move 1 step
            fast = fast.next.next;   // move 2 steps
        }

        /*
        Example: [5,4,2,1]

        head → 5 -> 4 -> 2 -> 1

        After loop:
        slow → 2
        (middle node)

        First half : 5 -> 4
        Second half: 2 -> 1
        */


        // STEP 2: Reverse second half
        ListNode prev = null;

        while (slow != null) {

            // save next node
            ListNode nextNode = slow.next;

            /*
            First iteration:
            slow → 2 -> 1
            nextNode → 1
            */

            // reverse link
            slow.next = prev;

            /*
            2 -> null
            because prev = null initially
            */

            // move prev forward
            prev = slow;

            /*
            prev → 2 -> null
            */

            // move slow forward
            slow = nextNode;

            /*
            slow → 1
            */


            /*
            Second iteration:

            nextNode = null

            reverse:
            1 -> 2 -> null

            prev → 1 -> 2 -> null

            slow → null

            loop ends
            */
        }

        /*
        After reversing:

        prev → 1 -> 2 -> null

        IMPORTANT:
        prev becomes NEW HEAD
        of reversed second half
        */


        // STEP 3: Compare twin nodes
        int maxSum = 0;

        ListNode first = head;
        ListNode second = prev;

        /*
        first → 5 -> 4 -> 2
        second → 1 -> 2

        Why?

        first = original first half
        second = reversed second half

        So twins align automatically:

        5 ↔ 1
        4 ↔ 2
        */

        while (second != null) {

            maxSum = Math.max(
                maxSum,
                first.val + second.val
            );

            /*
            Iteration 1:
            5 + 1 = 6

            maxSum = 6
            */

            first = first.next;
            second = second.next;

            /*
            first → 4
            second → 2
            */

            /*
            Iteration 2:
            4 + 2 = 6

            maxSum = 6
            */
        }

        return maxSum;
    }
}