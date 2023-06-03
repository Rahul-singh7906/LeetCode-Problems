class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n;i++){
            if(i==headID) continue;
            // adj.get(i).add(manager[i]);
            adj.get(manager[i]).add(i);
        }
        int[] vis=new int[n];
        return dfs(headID,adj,informTime,vis);
        
    }
    public int dfs(int node,List<List<Integer>> adj,int[] time,int[] vis){
        vis[node]=1;
        int maxi=0;
        for(int it:adj.get(node)){
            if(vis[it]==0){
                int tm=dfs(it,adj,time,vis);
                maxi=Math.max(maxi,tm);
            }
        }
        return maxi+time[node];
    }
}