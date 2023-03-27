class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        int ans=helper(coins,amount,coins.length-1,dp);
        if(ans==1000000000) return -1;
        return ans;
    }
    public int helper(int[] coins,int tar,int i,int[][] dp){                                         
        if(i==0){
            if(tar%coins[0]==0) return tar/coins[0];
            return (int)(Math.pow(10,9));
        }
        if(dp[i][tar]!=-1) return dp[i][tar];
        int nt=0;
        nt=0+helper(coins,tar,i-1,dp);
        int tk=(int)(Math.pow(10,9));
        if(tar>=coins[i]){
            tk=1+helper(coins,tar-coins[i],i,dp);
        }
        return dp[i][tar]=Math.min(nt,tk);
    }
}