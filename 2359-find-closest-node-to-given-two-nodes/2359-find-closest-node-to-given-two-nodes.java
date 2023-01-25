class Pair{
    int node;
    int weight;
    Pair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] a1=shortestDistance(node1,edges);
        int[] a2=shortestDistance(node2,edges);    
        int ansNode = -1;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<a1.length;i++){
            if(a1[i] != -1 && a2[i] != -1 ){
                int temp = Math.max(a1[i],a2[i]);
                if(temp < ans){
                    ans = temp;
                    ansNode = i;
                }
            }
        }  
        return ansNode;
    }
    public int[] shortestDistance(int src,int[] edges){
        int[] dis=new int[edges.length];
        Arrays.fill(dis,-1);
        dis[src]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.weight-y.weight);
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int node=p.node;
            int wt=p.weight;
            int next=edges[node];
            if (next != -1 && dis[next] == -1) { 
                pq.add(new Pair(next,dis[node] + 1));
                dis[next] = dis[node] + 1;
            }    
        }
        return dis;
    }
}