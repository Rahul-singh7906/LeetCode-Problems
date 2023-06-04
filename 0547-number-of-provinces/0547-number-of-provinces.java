class Solution {
    public int findCircleNum(int[][] isC) {
        int n=isC.length;
        int[] vis=new int[n];
        int ct=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                ct++;
                dfs(isC,vis,i+1);
            }
        }
        return ct;
    }
    public void dfs(int[][] grid,int[] vis,int node){
        vis[node-1]=1;
        for(int j=0;j<grid.length;j++){
            if(grid[node-1][j]==1){
                if(vis[j]==0) dfs(grid,vis,j+1);
            }
        }
    }
}