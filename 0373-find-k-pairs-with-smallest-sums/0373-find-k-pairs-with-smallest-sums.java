class Pair1{
    int val;
    int i;
    int j;
    Pair1(int val,int i,int j){
        this.val=val;
        this.i=i;
        this.j=j;
    }
    
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair1> pq=new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });
        int m=nums1.length;
        int n=nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pair<Integer, Integer>(0, 0));
        pq.add(new Pair1(nums1[0]+nums2[0],0,0));
        while(k-->0 && !pq.isEmpty()){
            Pair1 p=pq.poll();
            int i=p.i;
            int j=p.j;
            ans.add(List.of(nums1[i],nums2[j]));
            if (i + 1 < m && !visited.contains(new Pair<Integer, Integer>(i + 1, j))) {
                pq.offer(new Pair1(nums1[i + 1] + nums2[j], i + 1, j));
                visited.add(new Pair<Integer, Integer>(i + 1, j));
            }
            if (j + 1 < n && !visited.contains(new Pair<Integer, Integer>(i, j + 1))) {
                pq.offer(new Pair1(nums1[i] + nums2[j + 1], i, j + 1));
                visited.add(new Pair<Integer, Integer>(i, j + 1));
            }
        }
        return ans;
    }
}