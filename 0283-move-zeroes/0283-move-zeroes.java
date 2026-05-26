class Solution {
    public void moveZeroes(int[] arr) {
        // int index=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]!=0){
        //         nums[index]=nums[i];
        //         index++;
        //     }
        // }
        // while(index<nums.length){
        //     nums[index]=0;
        //     index++;
        // }
int left = 0; // pointer for placing non-zero elements

        for (int right = 0; right < arr.length; right++) {

            // If current element is non-zero
            if (arr[right] != 0) {

                // Swap elements
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
            }
        }

    }
}