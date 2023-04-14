class Disjoint{
    int[] parent;
    int[] size;
    Disjoint(int n){
        parent=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int findUlParent(int node){
        if(parent[node]==node) return node;
        return parent[node]=findUlParent(parent[node]);
    }
    public void unionBySize(int u,int v){
        int ulp_u=findUlParent(u);
        int ulp_v=findUlParent(v);
        if(ulp_u==ulp_v) return;
        if(size[ulp_u]<size[ulp_v]){
            parent[ulp_u]=ulp_v;
            size[ulp_v]+=size[ulp_u];
        }
        else{
            parent[ulp_v]=ulp_u;
            size[ulp_u]+=size[ulp_v];
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        Disjoint ds=new Disjoint(n);
        // List<List<Integer>> adj=new ArrayList<>();
        // for(int i=0;i<=n;i++){
        //     adj.add(new ArrayList<Integer>());
        // }
        // for(int i=0;i<n;i++){
        //     adj.get(edges[i][0]).add(edges[i][1]);
        //     // adj.get(edges[i][1]).add(edges[i][0]);
        // }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int ulp_u=ds.findUlParent(u);
            int ulp_v=ds.findUlParent(v);
            if(ulp_v!=ulp_u){
                ds.unionBySize(u,v);
            }
            else{
                return new int[]{u,v};
            }
        }
        return new int[]{1};
    }
}