class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        long windowSum=0;
        long maxSum=0;
        for(int i=0;i<nums.length;i++){
            windowSum+=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(i>=k){
                int remove=nums[i-k];
                windowSum-=remove;
                map.put(remove,map.get(remove)-1);
                if(map.get(remove)==0){
                    map.remove(remove);
                }
            }
            if(i>=k-1&&map.size()==k){
                maxSum=Math.max(maxSum,windowSum);
            }







        }


      return maxSum;




    }
}