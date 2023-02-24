class Solution {
    public int minimumDeviation(int[] nums) {
        int mini=Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0) {
                nums[i]=nums[i]*2;
            }
            pq.add(nums[i]);
            mini=Math.min(mini,nums[i]);
        }
        int dev=Integer.MAX_VALUE;
        while(true){
            int v=pq.poll();
            if(v%2!=0) {
                dev=Math.min(dev,Math.abs(v-mini));
                break;
            }
            dev=Math.min(dev,Math.abs(v-mini));
            v/=2;
            mini=Math.min(mini,v);
            pq.add(v);
        }
        return dev;
    }
}