class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        freq=[0]*100001
        left=0
        window_sum=0
        max_sum=0
        distinct_count=0
        for right in range(len(nums)):
            window_sum+=nums[right]
            freq[nums[right]]+=1
            if freq[nums[right]]==1:
                distinct_count+=1
            if right-left+1>k:
                remove=nums[left]
                window_sum-=remove
                freq[remove]-=1
                if freq[remove]==0:
                    distinct_count-=1
                left+=1

            if right-left+1==k and distinct_count==k:
                max_sum=max(max_sum,window_sum)
        return max_sum