class Solution {
    public int maxProfit(int[] prices, int fee) {
     int buy=2;
        int ind=prices.length;
        int[][] dp = new int[ind][buy];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(prices,0,1,dp,fee);
    }
    public int helper(int[] arr,int ind,int buy,int[][] dp,int f){
        if(ind>=arr.length) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max((-arr[ind]+(-f)+helper(arr,ind+1,0,dp,f)),(0+helper(arr,ind+1,1,dp,f)));
        }
        else{
        profit=Math.max((arr[ind]+helper(arr,ind+1,1,dp,f)),(0+helper(arr,ind+1,0,dp,f)));
        }
        return dp[ind][buy]=profit;
    }
}