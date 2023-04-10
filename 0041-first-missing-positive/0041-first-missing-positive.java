class Solution {
    public int firstMissingPositive(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
            maxi=Math.max(maxi,nums[i]);
        }
        maxi=Math.max(maxi,nums.length);
        for(int i=1;i<=maxi;i++){
            if(!hs.contains(i)) return i;
        }
        return maxi+1;
    }
}