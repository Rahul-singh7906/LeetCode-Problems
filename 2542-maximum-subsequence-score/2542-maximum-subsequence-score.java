class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pair=new int[nums1.length][2];
        for(int i=0;i<nums1.length;i++){
            pair[i]=new int[]{nums1[i],nums2[i]};
        }
        Arrays.sort(pair,(a,b)-> b[1]-a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sm=0;
        for(int i=0;i<k;i++){
            sm+=pair[i][0];
            pq.add(pair[i][0]);
        }
        long ans=sm*pair[k-1][1];
        for(int i=k;i<nums1.length;++i){
            sm+=pair[i][0]-pq.poll();
            pq.add(pair[i][0]);
            ans=Math.max(ans,sm*pair[i][1]);
        }
        return ans;
    }
}