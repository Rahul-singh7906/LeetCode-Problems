class Pair{
    int node;
    int dis;
    Pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dis=new int[n+1];
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int d=times[i][2];
            adj.get(u).add(new Pair(v,d));
        }
        Arrays.fill(dis,50000);
        dis[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)-> x.dis-y.dis);
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node=curr.node;
            int nodeDis=dis[node];
            for(Pair p:adj.get(node)){
                int adjNode=p.node;
                int adjDis=p.dis;
                if(adjDis+nodeDis<dis[adjNode]){
                    dis[adjNode]=adjDis+nodeDis;
                    pq.add(new Pair(adjNode,dis[adjNode]));
                }
            }
        }
        int maxi=0;
        for(int i=1;i<=n;i++){
            maxi=Math.max(maxi,dis[i]);
        }
        return maxi == 50000 ? -1 : maxi;
    }
}