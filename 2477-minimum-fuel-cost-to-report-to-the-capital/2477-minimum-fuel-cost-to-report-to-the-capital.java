class Solution {
    long fuel=0;
    public long minimumFuelCost(int[][] roads, int seats) {
        if(roads.length==0) return 0;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<roads.length+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
        }
        dfs(0,adj,seats,new int[roads.length+1]);
        return fuel;
    }
    public long dfs(int i,List<List<Integer>> adj,int seats,int[] vis){
        double c=0;
        if(i!=0) c=1;
        vis[i]=1;
        for(int it:adj.get(i)){
            if(vis[it]==0){
                c+=dfs(it,adj,seats,vis);
            }
        }
        if(i!=0){
            fuel+=(long)(Math.ceil(c/seats));
        }
        return (long)c;
    }
}