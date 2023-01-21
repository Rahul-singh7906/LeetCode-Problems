class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if(k==0){
            return Arrays.equals(nums1,nums2)?0:-1;
        }
        long p=0;
        long n=0;
        for(int i=0;i<nums1.length;i++){
            int d=nums1[i]-nums2[i];
            if(d%k!=0) return -1;
            if(d<0){
                n+=Math.abs((d/k));
            }
            else{
                p+=(d/k);
            }
        }
        if(p!=n) return -1;
        return Math.max(n,p);
    }
}