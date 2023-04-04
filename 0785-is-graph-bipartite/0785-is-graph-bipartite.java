class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] vis = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(vis[i]==0){
                vis[i]=1;
                if(helper(i,graph,vis)==false) return false;;
            }
        }
        return true;
    }
    public boolean helper(int i,int[][] graph,int[] vis){
        // Queue<Integer> q= new LinkedList<>();
        // q.add(i);
        // while(!q.isEmpty()){
        //     int val=q.poll();
        //     int clr=vis[val];
        //     for(int it:graph[val]){
        //         if(vis[it]==0){
        //             q.add(it);
        //             vis[it]=-clr;
        //         }
        //         else if(vis[val]!=-vis[it]) return false;
        //     }
        // }
        // return true;
        for(int it:graph[i]){
            if(vis[it]==0){
                vis[it]=-vis[i];
                if(helper(it,graph,vis)==false) return false;;
            }
            else if(vis[i]!=-vis[it]) return false;
        }
        return true;
    }
}