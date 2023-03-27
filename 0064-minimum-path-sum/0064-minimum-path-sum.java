class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] prev=new int[n+1];
        Arrays.fill(prev,(int)Math.pow(10,9));
        for(int i=1;i<m+1;i++){
            int[] curr=new int[n+1];
            curr[0]=(int)(Math.pow(10,9));
            for(int j=1;j<n+1;j++){
                if(i==1 && j==1){
                    curr[j]=grid[0][0];
                }
                else{
                    int up=grid[i-1][j-1]+prev[j];
                    int lf=grid[i-1][j-1]+curr[j-1];
                    curr[j]=Math.min(lf,up);
                }
            }
            prev=curr;
        }
        return prev[n];
    }
}