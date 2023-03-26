class Solution {
    public int maxProduct(int[] nums) {
        // if(nums.length==1) return nums[0];
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int p=nums[i];
            if(p>ans){
                    ans=p;
                }
            for(int j=i+1;j<nums.length;j++){
                p=p*nums[j];
                if(p>ans){
                    ans=p;
                }
            }
                
        }
        return ans;
    }
}