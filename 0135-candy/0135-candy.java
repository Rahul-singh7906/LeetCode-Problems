class Solution {
    public int candy(int[] ratings) {
        int nums[]=new int[ratings.length];
        Arrays.fill(nums,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]) nums[i]=nums[i-1]+1;
        }
        for(int i=nums.length-1;i>=1;i--){
            if(ratings[i-1]>ratings[i] && nums[i-1]<=nums[i]) nums[i-1]=nums[i]+1;
        }
        int s=0;
        for(int i:nums) s+=i;
        return s;
    }
}