class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1) return true;
        long s=1;
        long e=num;
        while(s<=e){
            long m=s+(e-s)/2;
            long sq=m*m;
            if(sq>num) e=m-1;
            else if(sq<num) s=m+1;
            else return true;
        }
        return false;
    }
}