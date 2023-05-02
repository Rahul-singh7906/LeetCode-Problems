class Solution {
    public double average(int[] salary) {
        double mini=Integer.MAX_VALUE;
        double maxi=Integer.MIN_VALUE;
        double s=0;
        for(int i:salary){
            s+=i;
            maxi=Math.max(maxi,i);
            mini=Math.min(mini,i);
        }
        s-=maxi;
        s-=mini;
        int len=salary.length-2;
        return s/=len;
    }
}