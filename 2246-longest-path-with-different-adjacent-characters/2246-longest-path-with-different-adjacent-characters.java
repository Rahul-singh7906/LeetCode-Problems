class Solution {
    int ans=1;
    int[] dist=new int[100005];
    public int longestPath(int[] parent, String s) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<parent.length;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<parent.length;i++){
            if(parent[i]!=-1){
                adj.get(parent[i]).add(i);
            }
        }
        dfs(0,adj,s);   
        return ans;
    }
    public void dfs(int i,List<List<Integer>> adj,String s){
        dist[i]=1;
        for(int it:adj.get(i)){
            dfs(it,adj,s);
            if(s.charAt(it)!=s.charAt(i)){
                ans=Math.max(ans,dist[i]+dist[it]);
                dist[i]=Math.max(dist[i],dist[it]+1);
            }
        }
    }
}