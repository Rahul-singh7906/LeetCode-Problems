class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n=nums.length;
        System.out.println(n);
        if(k>=nums.length){
            int[] arr=new int[n];
            Arrays.fill(arr,-1);
            return arr;
        }
        int i=0;
        int j=0;
        int lim=2*k+1;
        long sm=0;
        int[] arr=new int[n];
        Arrays.fill(arr,-1);
        int ind=k;
        while(j<n){
            sm+=nums[j];
            if(j-i+1<lim){
                j++;
            }
            else if(j-i+1==lim){
                int avg=(int)(sm/lim);
                arr[ind++]=avg;
                sm-=nums[i];
                i++;
                j++;
            }
        }
        return arr;
    }
}