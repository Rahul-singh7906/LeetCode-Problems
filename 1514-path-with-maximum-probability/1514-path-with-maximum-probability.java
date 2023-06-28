class Pair{
    int val;
    double weight;
    Pair(int val,double weight){
        this.val=val;
        this.weight=weight;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<Pair>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double wt=succProb[i];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {  
            public int compare(Pair a, Pair b) {
                if(a.weight < b.weight) return 1;
                else if(a.weight > b.weight) return -1;
                return 0;
            }
        }); 
        pq.add(new Pair(start,1));
        HashSet<Integer> hs = new HashSet<>();
        // hs.add(start);
        double ans=Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int node=p.val;
            double wt=p.weight;
            hs.add(node);
            if(node==end) ans=Math.max(ans,wt);
            for(Pair pr:adj.get(node)){
                if(!hs.contains(pr.val)){
                    pq.add(new Pair(pr.val,wt*pr.weight));
                }
            }
        }
        return ans== Integer.MIN_VALUE? 0 : ans;
    }
}