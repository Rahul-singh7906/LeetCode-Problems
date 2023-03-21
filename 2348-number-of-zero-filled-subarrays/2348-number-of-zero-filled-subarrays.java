class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                long ct=0;
                while(i<nums.length && nums[i]==0) {
                    i++;
                    ct++;
                }
                ans=ans+(ct*(ct+1))/2;
            }
        }
        return ans;
    }
}