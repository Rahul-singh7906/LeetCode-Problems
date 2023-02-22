class Solution {
    public int splitArray(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int i:weights){
            low=Math.max(low,i);
            high+=i;
        }
        int ans=high;
        while(low<=high){
            int mid=(high+low)/2;
            if(solver(weights,days,mid)==true){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean solver(int[] weights,int days,int high){
        int st=1;
        int s=0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]+s<=high){
                s+=weights[i];
            }
            else{
                s=0;
                s+=weights[i];
                st+=1;
            }
            if(st>days) return false;
        }
        
        return true;
    }
}