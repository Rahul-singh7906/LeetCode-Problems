class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        int ind=0;
        while(!pq.isEmpty()){
            nums[ind]=pq.poll();
            ind++;
        }
        return nums;
    }
}