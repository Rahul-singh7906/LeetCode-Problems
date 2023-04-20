class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][1]=speed[i];
            arr[i][0]=efficiency[i];
        }
        Arrays.sort(arr,(a,b)->{
            return -(a[0]-b[0]);
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long mod=1000000000+7;
        long spd=0;
        long ans=0;
        for(int i=0;i<n;i++){
            if(pq.size()>=k) spd-=pq.poll();
            pq.add(arr[i][1]);
            spd+=arr[i][1];
            ans=Math.max(ans,spd*arr[i][0]);
        }
        return (int)(ans%mod);
    }
}