class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=ages.length;
        int[][] dp2=new int[n][n];
        for(int[] row:dp2){
            Arrays.fill(row,-1);
        }
        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++){
            dp[i][0]=ages[i];
            dp[i][1]=scores[i];
        }
        Arrays.sort(dp,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        return helper(0,-1,dp,dp2);
    }
    public int helper(int ind,int prev,int[][] dp,int[][] dp2){
        if(ind==dp.length) return 0;
        if(prev!=-1 && dp2[ind][prev]!=-1) return dp2[ind][prev];
        int nt=Integer.MIN_VALUE;
        int tk=Integer.MIN_VALUE;
        if(prev==-1 || (dp[prev][0]==dp[ind][0]) || (dp[prev][0]<=dp[ind][0] && dp[prev][1]<=dp[ind][1])||(dp[prev][0]>dp[ind][0] && dp[prev][1]>=dp[ind][1])){
            tk=dp[ind][1]+helper(ind+1,ind,dp,dp2);
        }
        nt=0+helper(ind+1,prev,dp,dp2);
        int ans=Math.max(nt,tk);
        if(prev!=-1) return dp2[ind][prev]=ans;
        return ans;
    }
}