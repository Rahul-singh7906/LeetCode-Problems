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
    public int findCircleNum(int[][] isConnected) {
        int ct=0;
        int n=isConnected.length;
        Disjoint ds=new Disjoint(n);
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1){
                    ds.unionBySize(i+1,j+1);
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(ds.parent[i]==i) ct++;
        }
        return ct;
    }
}