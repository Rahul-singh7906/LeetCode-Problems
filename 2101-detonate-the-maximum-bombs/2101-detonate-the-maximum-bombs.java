class Solution {
    int ct=0;
    public int maximumDetonation(int[][] bombs) {
        int ans=0;
        for(int i=0;i<bombs.length;i++){
                ct=0;
                dfs(i,new boolean[bombs.length],bombs);
                ans=Math.max(ans,ct);
        }
        return ans;
    }
    public void dfs(int node,boolean[] vis,int[][] bombs){
        ct++;
        vis[node]=true;
        int n=bombs.length;
        for(int i=0;i<n;i++){
            if(vis[i]==false && isValid(bombs[node],bombs[i])){
                vis[i]=true;
                dfs(i,vis,bombs);
            }
        }
    }
    public boolean isValid(int[] a,int[] b){
        long d1=a[0]-b[0];
        long d2=a[1]-b[1];
        long r=a[2];
        return d1*d1+d2*d2<=r*r;
    }
}