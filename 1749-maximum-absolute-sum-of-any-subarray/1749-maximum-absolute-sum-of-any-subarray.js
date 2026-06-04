/**
 * @param {number[]} nums
 * @return {number}
 */
var maxAbsoluteSum = function(nums) {
    let maxSum=0;
    let minSum=0;
    let currMax=0;
    let currMin=0;
    for(let num of nums){
        currMax=Math.max(num,currMax+num);
        maxSum=Math.max(maxSum,currMax);

        currMin=Math.min(num,currMin+num);
        minSum=Math.min(minSum,currMin);
    }

    return Math.max(maxSum,Math.abs(minSum));




};