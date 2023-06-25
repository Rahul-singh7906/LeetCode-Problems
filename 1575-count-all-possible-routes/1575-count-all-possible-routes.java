class Solution {
    int mod=(int)(1e9)+7;
    public int countRoutes(int[] locations, int start, int finish, int fuel){
        int n=locations.length;
        int[][] dp=new int[n+1][201];
        for(int[] row:dp) Arrays.fill(row,-1);
        return helper(locations,start,finish,fuel,dp);
    }
    public int helper(int[] locations,int s,int e,int fuel,int[][] dp){
        if(fuel<0) return 0;
        if(dp[s][fuel]!=-1) return dp[s][fuel];
        int total=0;
        if(s==e) total=1;
        for(int i=0;i<locations.length;i++){
            if(i!=s && fuel>=Math.abs(locations[i]-locations[s])){
                total=(total+helper(locations,i,e,fuel-Math.abs(locations[i]-locations[s]),dp))%mod;
            }
        }
        return dp[s][fuel]=total;
    }
}