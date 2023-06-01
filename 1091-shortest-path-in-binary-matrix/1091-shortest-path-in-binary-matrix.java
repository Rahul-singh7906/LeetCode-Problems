class Pair{
    int first;
    int second;
    int distance;
    Pair(int first,int second,int distance){
        this.first=first;
        this.second=second;
        this.distance=distance;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        if(grid.length==1){
            if(grid[0][0]==0) return 1;
            return -1;
        }
        int n=grid.length;
        int[][] dis=new int[n][n];
        for(int[] row:dis) Arrays.fill(row,(int)(1e9));
        bfs(grid,0,0,n,dis);
        if(dis[n-1][n-1]==(int)(1e9)) return -1;
        return dis[n-1][n-1]+1;
    }
    public void bfs(int[][] grid,int i,int j,int n,int[][] dis){
        int[] drow={-1,0,1};
        int[] dcol={-1,0,1};
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(i,j,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int x=p.first;
            int y=p.second;
            int dist=p.distance;
            for(int r=0;r<drow.length;r++){
                for(int c=0;c<dcol.length;c++){
                    int nr=x+drow[r];
                    int nc=y+dcol[c];
                    if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0 && dist+1<dis[nr][nc]){
                        dis[nr][nc]=1+dist;
                        q.add(new Pair(nr,nc,dis[nr][nc]));
                    }
                }
            }
        }
    }
}