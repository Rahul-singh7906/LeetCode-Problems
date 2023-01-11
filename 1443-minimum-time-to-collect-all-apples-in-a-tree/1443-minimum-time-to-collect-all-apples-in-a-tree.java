class Solution {
    int f=0;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] vis=new int[n];
        Arrays.fill(vis,-1);
        return helper(0,vis,adj,hasApple);
    }
    public int helper(int i,int[] vis,List<List<Integer>> adj,List<Boolean> ck){
        vis[i]=1;
        int ct=0;
        for(int it:adj.get(i)){
            if(vis[it]==-1){
                ct+=helper(it,vis,adj,ck);
            }
        }    
        if(i!=0 && (ck.get(i)==true || ct>0)) ct+=2;
        return ct;
    }
}