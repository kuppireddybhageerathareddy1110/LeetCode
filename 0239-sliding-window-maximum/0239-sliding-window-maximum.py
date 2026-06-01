from collections import deque

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        dq = deque()   # stores indices
        result = []

        for i in range(len(nums)):

            # Remove indices outside the window
            while dq and dq[0] <= i - k:
                dq.popleft()

            # Remove smaller elements from back
            while dq and nums[dq[-1]] < nums[i]:
                dq.pop()

            # Add current index
            dq.append(i)

            # Add max to result once window is complete
            if i >= k - 1:
                result.append(nums[dq[0]])

        return result