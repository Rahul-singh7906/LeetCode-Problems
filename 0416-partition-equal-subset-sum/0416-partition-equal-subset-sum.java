class Solution {
    public boolean canPartition(int[] nums) {
        int s=0;
        for(int i:nums) s+=i;
        if(s%2!=0) return false;
        int[][] dp=new int[nums.length][s/2+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return helper(nums,nums.length-1,s/2,dp);
    }
    public boolean helper(int[] arr,int i,int s,int[][] dp){
        if(s==0) return true;
        if(i==0){
            if(s==arr[i]) return true;
            return false;
        }
        if(dp[i][s]!=-1) {
            if(dp[i][s]==1) return true;
            return false;
        }
        boolean nt=helper(arr,i-1,s,dp);
        boolean tk=false;
        if(arr[i]<=s){
            tk=helper(arr,i-1,s-arr[i],dp);
        }
        if(nt||tk==true) dp[i][s]=1;
        else dp[i][s]=0;
        return nt||tk;
    }
}