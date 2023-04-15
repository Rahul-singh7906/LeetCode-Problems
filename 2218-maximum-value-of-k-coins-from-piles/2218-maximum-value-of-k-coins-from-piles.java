class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp=new int[piles.size()][k+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return helper(piles.size()-1,piles,k,dp);
    }
    public int helper(int ind,List<List<Integer>> piles, int k,int[][] dp){
        if(ind<0 || k==0){
            return 0;
        }
        if(dp[ind][k]!=-1) return dp[ind][k];
        int nt=0+helper(ind-1,piles,k,dp);
        int tk=0;
        int lim=Math.min(piles.get(ind).size(),k);
        for(int j=0,sm=0;j<lim;j++){
            sm+=piles.get(ind).get(j);
            tk=Math.max(sm+helper(ind-1,piles,k-j-1,dp),tk);
        }
        return dp[ind][k]=Math.max(nt,tk);
    }
}