class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(nums,0,-1,dp);
    }
    public int helper(int[] arr,int ind,int prev,int[][] dp){
        if(ind>=arr.length) return 0;
        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];
        int nt=Integer.MIN_VALUE;
        int tk=Integer.MIN_VALUE;
        nt=0+helper(arr,ind+1,prev,dp);
        if(prev==-1 || arr[ind]>arr[prev]){
            tk=1+helper(arr,ind+1,ind,dp);
        }
        return dp[ind][prev+1]=Math.max(nt,tk);
    }
}