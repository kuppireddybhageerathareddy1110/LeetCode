class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
       int[] freq=new int[100001];
       long windowSum=0;
       long maxSum=0;
       int distinctCount=0;
       for(int i=0;i<nums.length;i++){
        windowSum+=nums[i];
        freq[nums[i]]++;
        if(freq[nums[i]]==1){
            distinctCount++;
        }
        if(i>=k){
            int remove=nums[i-k];
            windowSum-=remove;
            freq[remove]--;
            if(freq[remove]==0){
                distinctCount--;
            }
        }
        if(i>=k-1&&distinctCount==k){
            maxSum=Math.max(maxSum,windowSum);
        }

       }
       return maxSum;
    }
}