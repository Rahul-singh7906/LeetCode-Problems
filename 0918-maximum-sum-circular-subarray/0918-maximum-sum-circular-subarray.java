class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int s=0;
        int sm=0;
        int n=nums.length;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            s+=nums[i];
            ans=Math.max(ans,s);
            if(s<0) s=0;
        }
        s=0;
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*-1;
        }
        for(int i=0;i<nums.length;i++){
            sm+=nums[i];
        }
        int maxi2=nums[0];
        for(int i=0;i<nums.length;i++){
            s+=nums[i];
            maxi2=Math.max(maxi2,s);
            if(s<0) s=0;
        }
        int ans2=-(sm-maxi2);
        if(ans2==0) return ans;
        return Math.max(ans,ans2);
    }
}