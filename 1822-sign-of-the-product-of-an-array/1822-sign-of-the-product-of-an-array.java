class Solution {
    public int arraySign(int[] nums) {
        int z=0;
        int n=0;
        int p=0;
        for(int i:nums){
            if(i<0) n++;
            else if(i>0) p++;
            else z++;
        }
        if(z>0) return 0;
        if(n%2==0) return 1;
        return -1;
    }
}