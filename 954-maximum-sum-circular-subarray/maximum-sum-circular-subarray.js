/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubarraySumCircular = function(nums) {
    let totalSum=nums[0];
    let maxSum=nums[0];
    let currentMax=nums[0];
    let minSum=nums[0];
    let currentMin=nums[0];

    for(let i=1;i<nums.length;i++){
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





};