class Solution {
    public int[] sortedSquares(int[] nums) {
        int p1=0;
        int p2=nums.length-1;
        int ind=nums.length-1;
        int[] ans=new int[nums.length];
        while(p1<=p2){
            int v1=nums[p1]*nums[p1];
            int v2=nums[p2]*nums[p2];
            if(v1>v2) {
                ans[ind]=v1;
                p1++;
            }
            else{
                ans[ind]=v2;
                p2--;
            }
            ind--;
        }
        return ans;
    }
}