class Solution {
    // public long countSubarrays(int[] nums, int minK, int maxK) {
    //     int left=-1;
    //     int mini=-1;
    //     int maxi=-1;
    //     long ans=0;
    //     for(int i=0;i<nums.length;++i){
    //         if(nums[i]<minK || nums[i]>maxK) left=i;
    //         if(nums[i]==mini) mini=i;
    //         if(nums[i]==maxK) maxi=i;
            
    //         ans += Math.max(0, Math.min(maxi, mini) - left);
    //     }
    //     return ans;
    // }
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;   
        int min=-1, max=-1, left = -1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]<minK || nums[i] > maxK) {
                left = min = max = i;
            } 
            min = nums[i]==minK ? i : min;
            max = nums[i]==maxK ? i : max;
            res += Math.min(max, min)-left;  
        }
        return res;
    }
}

