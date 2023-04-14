class Solution {
    public int longestPalindromeSubseq(String s1) {
        String s2="";
        int n=s1.length();
        int[][] dp=new int[n][n];
        for(int[] row:dp) Arrays.fill(row,-1);
        for(int i=n-1;i>=0;i--){
            s2+=s1.charAt(i);
        }
        return helper(s1,s2,0,0,dp);
    }
    public int helper(String s1,String s2,int i,int j,int[][] dp){
        if(i==s1.length() || j==s2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int eq=0;
        int nq=0;
        if(s1.charAt(i)==s2.charAt(j)){
            eq=1+helper(s1,s2,i+1,j+1,dp);
        }
        else{
            nq=0+Math.max(helper(s1,s2,i+1,j,dp),helper(s1,s2,i,j+1,dp));
        }
        return dp[i][j]=Math.max(eq,nq);
    }
}