class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        total_sum=nums[0]
        max_sum=nums[0]
        current_max=nums[0]
        min_sum=nums[0]
        current_min=nums[0]
        for i in range(1,len(nums)):
            total_sum+=nums[i]
            current_max=max(nums[i],current_max+nums[i])
            max_sum=max(max_sum,current_max)
            current_min=min(nums[i],current_min+nums[i])
            min_sum=min(min_sum,current_min)
        if max_sum<0:
            return max_sum
        return max(max_sum,total_sum-min_sum)
        