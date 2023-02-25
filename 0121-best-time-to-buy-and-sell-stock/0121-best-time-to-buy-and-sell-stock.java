class Solution {
    public int maxProfit(int[] prices) {
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        int profit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<mini){
                mini=prices[i];
                maxi=Integer.MIN_VALUE;
            }
            else{
                maxi=Math.max(maxi,prices[i]);
                profit=Math.max(profit,maxi-mini);
            }
        }
        return profit;
    }
}