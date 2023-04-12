class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int maxi=Integer.MIN_VALUE;
        for(int it:hm.keySet()){
            maxi=Math.max(maxi,hm.get(it));
        }
        for(int it:hm.keySet()){
            if(hm.get(it)==maxi) return it;
        }
        return -1;
    }
}