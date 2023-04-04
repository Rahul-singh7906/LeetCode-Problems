class Solution {
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int[][] vis=new int[m][n];
        for(int[] row:vis) Arrays.fill(row,0);
        int ct=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    ct++;
                    dfs(i,j,vis,grid);
                }
            }
        }
        return ct;
    }
    public void dfs(int i,int j,int[][] vis,char[][] grid){
        vis[i][j]=1;
        int[] drow={-1,0,1,0};
        int[] dcol={0,-1,0,1};
        for(int ind=0;ind<drow.length;ind++){
            int nr=i+drow[ind];
            int nc=j+dcol[ind];
            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1' && vis[nr][nc]==0){
                dfs(nr,nc,vis,grid);
            }
        }
    }
}