class Pair{
    int fir;
    int sec;
    int dis;
    Pair(int fir,int sec,int dis){
        this.fir=fir;
        this.sec=sec;
        this.dis=dis;
    }
}
class Solution {
    public int maxDistance(int[][] grid) {   
       Queue<Pair> pq=new LinkedList<>();
       int n=grid.length;
       int m=grid[0].length;
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(grid[i][j]==1) pq.add(new Pair(i,j,0));
           }
       }
       int[] drow={-1,0,1,0};
       int[] dcol={0,-1,0,1};
       int ans=-1;
       while(!pq.isEmpty()){
            Pair p = pq.poll();
            int row=p.fir;
            int col=p.sec;
            int dis=p.dis;
            ans=Math.max(ans,dis);
            for(int i=0;i<4;i++){
                if(row+drow[i]>=0 && row+drow[i]<n && col+dcol[i]>=0 && col+dcol[i]<m){
                    int nr=row+drow[i];
                    int nc=col+dcol[i];
                    if(grid[nr][nc]==0){
                        grid[nr][nc]=1;
                        pq.add(new Pair(nr,nc,dis+1));
                    }
                }
            }
       }
       return ans==0?-1:ans;

    }
   
}