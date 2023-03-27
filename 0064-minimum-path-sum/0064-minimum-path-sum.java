class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            dp[i][0]=(int)Math.pow(10,9);
        }
        for(int i=0;i<n+1;i++){
            dp[0][i]=(int)Math.pow(10,9);
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(i==1 && j==1){
                    dp[i][j]=grid[0][0];
                }
                else{
                    int up=grid[i-1][j-1]+dp[i-1][j];
                    int lf=grid[i-1][j-1]+dp[i][j-1];
                    dp[i][j]=Math.min(lf,up);
                }
            }
        }
        return dp[m][n];
    }
//     public int helper(int i,int j,int[][] arr,int[][] dp){
//         if(i==0 && j==0){
//             return arr[0][0];
//         }
//         if(i<0 || j<0){
//             return (int)Math.pow(10,9);
//         }
//         if(dp[i][j]!=-1) return dp[i][j];
//         int up=arr[i][j]+helper(i-1,j,arr,dp);
//         int lf=arr[i][j]+helper(i,j-1,arr,dp);
//         return dp[i][j]=Math.min(lf,up);
        
        
//     }
}