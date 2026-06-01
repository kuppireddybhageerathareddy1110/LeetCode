class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        result = []

        # Manual deque using list
        dq = [0] * n
        front = 0
        rear = -1

        for i in range(n):

            # Remove indices outside current window
            if front <= rear and dq[front] <= i - k:
                front += 1

            # Remove smaller elements from rear
            while front <= rear and nums[dq[rear]] < nums[i]:
                rear -= 1

            # Add current index
            rear += 1
            dq[rear] = i

            # Add maximum to result
            if i >= k - 1:
                result.append(nums[dq[front]])

        return result