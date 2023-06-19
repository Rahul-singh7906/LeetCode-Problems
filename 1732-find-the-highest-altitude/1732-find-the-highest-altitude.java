class Solution {
    public int largestAltitude(int[] gain) {
        int maxi=0;
        int s=0;
        for(int i:gain){
            s+=i;
            maxi=Math.max(maxi,s);
        }
        return maxi;
    }
}