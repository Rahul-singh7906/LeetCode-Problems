class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        // long t=0;
        long s=1;
        int mini=Integer.MAX_VALUE;
        int n=time.length;
        for(int i=0;i<n;i++){
            mini=Math.max(mini,time[i]);
        }
        // long ans=0;
        long e= 100000000000000L;
        while(s<e){
            long m=s+(e-s)/2;
            if(isValid(m,time,totalTrips)){
                e=m;
            }
            else{
                s=m+1;
            }
        }
        return s;
    }
public boolean isValid(long tm,int[] time,int total){
        long s=0;
        // int[] ct=new int[time.length];
        for(int i=0;i<time.length;i++){
            // ct[i]=(int)
            s+=tm/time[i];
        }
        if(s>=total) return true;
        return false;
    }
}