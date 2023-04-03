class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0) return true;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj.get(v).add(u);
        }
        int[] in= new int[numCourses];
            for(int i=0;i<numCourses;i++){
                for(int it:adj.get(i)){
                    in[it]++;
                }
            }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++){
            if(in[i]==0) {
                q.add(i);
            }
        }
        int sz=0;
        while(!q.isEmpty()){
            int v=q.poll();
            sz++;
            for(int it:adj.get(v)){
                in[it]--;
                if(in[it]==0) q.add(it);
            }
        }
        if(sz==numCourses) return true;
        return false;
    }
}