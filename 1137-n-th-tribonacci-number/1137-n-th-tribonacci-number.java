class Solution {
    public int tribonacci(int n) {
        int ans=0;
        int p1=0;
        int p2=1;
        int p3=1;
        if(n==0) return p1;
        else if(n==1) return p2;
        else if(n==2) return p3;
            int ct=3;
            while(ct<=n){
                ans=p1+p2+p3;
                p1=p2;
                p2=p3;
                p3=ans;
                ct++;
            }
            return ans;
    }
}