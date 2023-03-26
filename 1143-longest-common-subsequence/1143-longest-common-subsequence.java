class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<n+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int nf=0+Math.max(dp[i-1][j],dp[i][j-1]);
                int fd=0;
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    fd=1+dp[i-1][j-1];
                }
                dp[i][j]=Math.max(nf,fd);
            }
        }
        return dp[m][n];
    }
    // public int helper(String s1,String s2,int i,int j,int[][] dp){
    //     if(i<0 || j<0) return 0;
    //     if(i==0 || j==0){
    //         if(s1.charAt(i)==s2.charAt(j)) return 1;
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int nf=0+Math.max(helper(s1,s2,i-1,j,dp),helper(s1,s2,i,j-1,dp));
    //     int fd=0;
    //     if(s1.charAt(i)==s2.charAt(j)){
    //         fd=1+helper(s1,s2,i-1,j-1,dp);
    //     }
    //     return dp[i][j]=Math.max(nf,fd);
    // }
}