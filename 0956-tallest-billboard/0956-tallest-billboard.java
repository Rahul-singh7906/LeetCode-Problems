class Solution {
    public int tallestBillboard(int[] rods) {
        int n=rods.length;
        int[][] dp=new int[n+1][10001];
        for(int[] row:dp) Arrays.fill(row,-1);
        return helper(rods,0,n-1,dp);
    }
    public int helper(int[] rods,int diff,int i,int[][] dp){
        if(i<0){
            if(diff==0) return 0;
            return Integer.MIN_VALUE;
        }
        if(dp[i][diff+5000]!=-1) return dp[i][diff+5000];
        int nt=helper(rods,diff,i-1,dp);
        int tk1=helper(rods,diff-rods[i],i-1,dp);
        int tk2=rods[i]+helper(rods,diff+rods[i],i-1,dp);
        return dp[i][diff+5000]=Math.max(nt,Math.max(tk1,tk2));
    }
}