class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
            int n=nums.length;
            long ans=0;
            Arrays.sort(nums);
            int s=1;
            int e=nums.length-1;
            for(int i=0;i<nums.length;i++){
                while(e>0 && nums[i]+nums[e]>upper) e--;
                s=i+1;
                while(s<nums.length && nums[i]+nums[s]<lower) s++;
                if(s<=e) ans+=(e-s+1);
            }
            return ans;
    }
}