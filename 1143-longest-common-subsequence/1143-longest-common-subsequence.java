class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(text1,text2,m-1,n-1,dp);
    }
    public int helper(String s1,String s2,int i,int j,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int nf=0+Math.max(helper(s1,s2,i-1,j,dp),helper(s1,s2,i,j-1,dp));
        int fd=0;
        if(s1.charAt(i)==s2.charAt(j)){
            fd=1+helper(s1,s2,i-1,j-1,dp);
        }
        return dp[i][j]=Math.max(nf,fd);
    }
}