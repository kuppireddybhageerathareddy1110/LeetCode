class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum=nums[0];
        int maxSum=nums[0];
        int currentMax=nums[0];

        int minSum=nums[0];
        int currentMin=nums[0];
        for(int i=1;i<nums.length;i++){
            totalSum+=nums[i];
            currentMax=Math.max(nums[i],currentMax+nums[i]);
            maxSum=Math.max(maxSum,currentMax);

            currentMin=Math.min(nums[i],currentMin+nums[i]);
            minSum=Math.min(minSum,currentMin);
        }
        if(maxSum<0){
            return maxSum;
        }
        return Math.max(maxSum,totalSum-minSum);
    }
}