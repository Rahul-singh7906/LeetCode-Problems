class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] vis=new int[n+1];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<dislikes.length;i++){
            adj.get(dislikes[i][0]).add(dislikes[i][1]);
            adj.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        for(int i=1;i<=n;i++){
            if(vis[i]==0){
                vis[i]=1;
                if(dfs(i,adj,vis)==false) return false;
            }
        }
        return true;
    }
    public boolean dfs(int i,List<List<Integer>> adj,int[] vis){
        int color=vis[i];
        for(int it:adj.get(i)){
            if(vis[it]==0){
                vis[it]=-color;
                if(dfs(it,adj,vis)==false) return false;
            }
            else if(vis[it]!=-color) return false;
        }
        return true;
    }
}