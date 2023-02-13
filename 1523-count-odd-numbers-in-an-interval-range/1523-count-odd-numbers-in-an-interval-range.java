class Solution {
    public int countOdds(int low, int high) {
        if(low==high )
        {
            if(low%2!=0) return 1;
            return 0;
        }
        int eval1=high-low-1;
        int ans=0;
        if(low%2!=0 && high%2!=0){
            ans=eval1/2;
            ans+=2;
            return ans;
        }
        else{
            ans=eval1/2;
            ans+=1;
        }
        return ans;
    }
}