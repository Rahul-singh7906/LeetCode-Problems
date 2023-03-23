class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<connections.length;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        int ct=0;
        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                ct++;
                dfs(i,vis,adj);
            }
        }
        return ct-1;
    }
    public void dfs(int i,int[] vis,List<List<Integer>> adj){
        vis[i]=1;
        for(int it:adj.get(i)){
            if(vis[it]==0){
                dfs(it,vis,adj);
            }
        }
    }
}