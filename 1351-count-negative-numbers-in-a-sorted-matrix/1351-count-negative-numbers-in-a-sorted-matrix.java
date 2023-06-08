class Solution {
    public int countNegatives(int[][] grid) {
        int ct=0;
        for(int i=0;i<grid.length;i++){
            int j=search(grid[i]);
            ct+=grid[0].length-1-j;
        }
        return ct;
    }
    public int search(int[] arr){
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(arr[m]>=0) s=m+1;
            else e=m-1;
        }
        return e;
    }
}