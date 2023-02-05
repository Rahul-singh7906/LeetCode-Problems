class Pair{
    int diff;
    int u;
    int v;
    Pair(int diff,int u,int v){
        this.diff=diff;
        this.u=u;
        this.v=v;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.diff-b.diff);
        pq.add(new Pair(0,0,0));
        int m=heights.length;
        int n=heights[0].length;
        int[][] dis=new int[m][n];
        // int diff=Integer.MAX_VALUE;
        for(int[] row:dis){
            Arrays.fill(row,(int)(1e9));
        }
        dis[0][0]=0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,-1,0,1};
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int diff=p.diff;
            int row=p.u;
            int col=p.v;
            if(row==m-1 && col==n-1) return diff;
            for(int i=0;i<4;i++){
                int nr=row+drow[i];
                int nc=col+dcol[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int newEffort=Math.max(diff,Math.abs((heights[nr][nc]-heights[row][col])));
                    if(newEffort<dis[nr][nc]){
                        dis[nr][nc]=newEffort;
                        pq.add(new Pair(newEffort,nr,nc));
                    }                 
                }
            }
        }
        return 0;  
    }
}