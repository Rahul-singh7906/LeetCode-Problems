class Pair{
    int val;
    int ind;
    Pair(int val,int ind){
        this.val=val;
        this.ind=ind;
    }
}
class Solution {
    public long totalCost(int[] costs, int k, int len) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.val==b.val) return a.ind-b.ind;
            return a.val-b.val;
        });
        List<Integer> ls = new ArrayList<>();
        for(int i:costs) ls.add(i);
        long ans=0;
        int n = costs.length;
            int i, j;
            for (i = 0, j = n - 1; i <= j && i < len; i++, j--)
            {
                pq.add(new Pair(costs[i], i));
                if (i != j) pq.add(new Pair(costs[j], j));
            }
        int low = i, high = j;
        while(!pq.isEmpty() && k>0){
            Pair minPair = pq.poll();
            int minVal = minPair.val;
            int minIndex = minPair.ind;
            
            ans += minPair.val;
            k--;
            
            if (low > high) continue;
            
            int dist1 = Math.abs(low - minIndex);
            int dist2 = Math.abs(high - minIndex);
            if (dist1 < dist2) pq.add(new Pair(costs[low], low++));
            else pq.add(new Pair(costs[high], high--));
        }
        return ans;
    }
}