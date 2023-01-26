class Pair{
    int node;
    int dist;
    int stops;
    Pair(int node,int dist,int stops){
        this.node=node;
        this.dist=dist;
        this.stops=stops;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v,wt,0));
        }
        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(src,0,0));
        int[] dis=new int[n];
        Arrays.fill(dis,(int)(1e9));
        dis[src]=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int node=p.node;
            int dist=p.dist;
            int stop=p.stops;
            for(Pair it:adj.get(node)){
                int adjNode=it.node;
                int wt=it.dist;
                if(stop+1<=k+1) {
                    if(wt+dist<dis[adjNode]){
                        dis[adjNode]=wt+dist;
                        pq.add(new Pair(adjNode,dis[adjNode],stop+1));
                    }
                }
            }
        }
        if(dis[dst]!=1e9) return dis[dst];
        return -1;
    }
}