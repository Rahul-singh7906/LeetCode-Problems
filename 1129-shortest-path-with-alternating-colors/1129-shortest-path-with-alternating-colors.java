class Pair{
    int u;
    int dis;
    int f;
    Pair(int u,int dis,int f){
        this.u=u;
        this.dis=dis;
        this.f=f;
    }
}
class Duo{
    int neighbour;
    int color;
    Duo(int neighbour,int color){
        this.neighbour=neighbour;
        this.color=color;
    }
}
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Duo>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Duo>());
        }
        for(int i=0;i<redEdges.length;i++){
            int u=redEdges[i][0];
            int v=redEdges[i][1];
            adj.get(u).add(new Duo(v,0));
        }
        for(int i=0;i<blueEdges.length;i++){
            int u=blueEdges[i][0];
            int v=blueEdges[i][1];
            adj.get(u).add(new Duo(v,1));
        }
        int[] arr=helper(n,adj);
        return arr;
    }
    public int[] helper(int n,List<List<Duo>> adj){
        Queue<Pair> pq = new LinkedList<>();
        int[] dis = new int[n];
        Arrays.fill(dis,-1);
        dis[0]=0;
        pq.add(new Pair(0,0,-1));
        boolean[][] vis= new boolean[n][2];
        vis[0][1]=vis[0][0]=true;
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int node=pair.u;
            int d=pair.dis;
            int prev=pair.f;
            for(Duo it:adj.get(node)){
                int neighbour=it.neighbour;
                int color=it.color;
                if(!vis[neighbour][color] && color!=prev){
                    if(dis[neighbour]==-1){
                        dis[neighbour]=1+d;
                    }
                    vis[neighbour][color]=true;
                    pq.add(new Pair(neighbour,1+d,color));
                }
            }
        }
        return dis;
    }
}