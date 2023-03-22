class Pair{
    int v;
    int wt;
    Pair(int v,int wt){
        this.v=v;
        this.wt=wt;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        int[] vis=new int[n+1];
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int wt=roads[i][2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        int ans=Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1]=1;
        while(!q.isEmpty()){
            int node=q.poll();
            if(adj.get(node).size()==0) continue;
            for(Pair pr:adj.get(node)){
                ans=Math.min(pr.wt,ans);
                if(vis[pr.v]==0){
                    vis[pr.v]=1;
                    q.add(pr.v);
                }
            }
        }
        return ans;
    }
}