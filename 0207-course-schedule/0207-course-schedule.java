class Solution {
    public boolean canFinish(int num, int[][] pr) {
        if(pr.length==0) return true;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<num;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<pr.length;i++){
            int u=pr[i][0];
            int v=pr[i][1];
            adj.get(v).add(u);
        }
        Queue<Integer> q=new LinkedList<>();
        int[] indegree=new int[num];
        for(int i=0;i<adj.size();i++){
            for(int it:adj.get(i)) indegree[it]++;
        }
        for(int i=0;i<num;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> ls = new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            ls.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(ls.size()==num) return true;
        return false;
    }
}