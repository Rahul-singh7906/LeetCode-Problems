class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // if(piles.length==1){
        //     if(piles[0]<=h) return 1;
        //     else{
        //         if(piles[0]%h==0){
        //             return piles[0]/h;
        //         }
        //         else{
        //             return (piles[0]/h)+1;
        //         }
        //     }
        // }
        // int ans=0;
        int s=1;
        int e=1000000000;
        while(s<e){
            int mid=s+(e-s)/2;
            if(isValid(mid,piles,h)){
                // ans=mid;
                e=mid;
            }
            else s=mid+1;
        }
        return s;
    }
    public boolean isValid(int k,int[] piles,int h){
        int hours = 0;
        for(int pile : piles){
            int div = pile / k;
            hours += div;
            if(pile % k != 0) hours++;
        }
        return hours <= h;
    }
}