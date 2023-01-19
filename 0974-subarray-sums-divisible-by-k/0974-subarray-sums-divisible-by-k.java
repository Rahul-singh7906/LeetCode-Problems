class Solution {
    public int subarraysDivByK(int[] nums, int k) {
       HashMap<Integer,Integer> hm=new HashMap<>();
       int ans=0;
       int sm=0;
       hm.put(0,1);
       for(int v:nums){
           sm=(sm+v)%k;
           if(sm<0) sm+=k;
           if(hm.containsKey(sm)){
               ans+=hm.get(sm);
           }
           hm.put(sm,hm.getOrDefault(sm,0)+1);
       }
       return ans;
    }
}