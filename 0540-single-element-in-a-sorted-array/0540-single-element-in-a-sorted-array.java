class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ind=1;
        while(ind<nums.length){
            int xor=nums[ind]^nums[ind-1];
            if(xor!=0) return nums[ind-1];
            ind+=2;
        }
        return nums[nums.length-1];
    }
}