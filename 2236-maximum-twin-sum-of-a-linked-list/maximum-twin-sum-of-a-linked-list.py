# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:

        # -----------------------------------
        # STEP 1: Find middle of linked list
        # -----------------------------------

        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next       # move 1 step
            fast = fast.next.next  # move 2 steps

        """
        Example:
        head = [5,4,2,1]

        Linked List:
        5 -> 4 -> 2 -> 1

        After loop:

        slow → 2
        fast → None

        So:
        First half  = 5 -> 4
        Second half = 2 -> 1
        """



        # -----------------------------------
        # STEP 2: Reverse second half
        # -----------------------------------

        prev = None

        while slow:

            # save next node
            next_node = slow.next

            """
            First iteration:

            slow → 2 -> 1
            next_node → 1
            """

            # reverse link
            slow.next = prev

            """
            Before:
            2 -> 1

            After:
            2 -> None
            because prev = None initially
            """

            # move prev forward
            prev = slow

            """
            prev → 2 -> None
            """

            # move slow forward
            slow = next_node

            """
            slow → 1
            """

            """
            Second iteration:

            next_node = None

            reverse:
            1 -> 2 -> None

            prev → 1 -> 2 -> None

            slow → None
            loop stops
            """

        """
        Final reversed second half:

        prev → 1 -> 2 -> None

        IMPORTANT:
        prev is now the HEAD
        of reversed linked list
        """



        # -----------------------------------
        # STEP 3: Compare twin sums
        # -----------------------------------

        max_sum = 0

        first = head
        second = prev

        """
        first  → 5 -> 4 -> 2
        second → 1 -> 2

        Why?

        second points to reversed half.

        Twin pairs become aligned:

        5 ↔ 1
        4 ↔ 2
        """

        while second:

            # calculate twin sum
            twin_sum = first.val + second.val

            # update maximum
            max_sum = max(max_sum, twin_sum)

            """
            Iteration 1:
            5 + 1 = 6

            max_sum = 6
            """

            # move both pointers
            first = first.next
            second = second.next

            """
            first → 4
            second → 2

            Iteration 2:
            4 + 2 = 6

            max_sum = 6
            """

        return max_sum