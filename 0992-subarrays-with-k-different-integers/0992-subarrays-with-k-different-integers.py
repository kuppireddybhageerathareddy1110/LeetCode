class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        return self.atMostK(nums,k)-self.atMostK(nums,k-1)

    def atMostK(self,nums,k):
        left=0
        count=0
        freq={}
        for right in range(len(nums)):
            freq[nums[right]]=freq.get(nums[right],0)+1
            while len(freq)>k:
                freq[nums[left]]-=1
                if freq[nums[left]]==0:
                    del freq[nums[left]]
                left+=1
            count+=(right-left+1)
        return count
    