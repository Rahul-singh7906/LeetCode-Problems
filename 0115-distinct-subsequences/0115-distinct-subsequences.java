class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return helper(s,t,0,0,dp);
    }
    public int helper(String s,String t,int p1,int p2,int[][] dp){
        if(p2==t.length()) return 1;
        if(p1==s.length()) return 0;
        if(dp[p1][p2]!=-1) return dp[p1][p2];
        int ans=helper(s,t,p1+1,p2,dp);
        if(s.charAt(p1)==t.charAt(p2)) {
            ans+=helper(s,t,p1+1,p2+1,dp);
        }
        dp[p1][p2]=ans;
        return ans;
    }
}