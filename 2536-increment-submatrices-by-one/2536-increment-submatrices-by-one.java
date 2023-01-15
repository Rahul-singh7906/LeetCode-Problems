class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] arr=new int[n][n];
        for(int i=0;i<queries.length;i++){
            int ir=queries[i][0];
            int ic=queries[i][1];
            int fr=queries[i][2];
            int fc=queries[i][3];
            for(int r=ir;r<=fr;r++){
                for(int c=ic;c<=fc;c++){
                    arr[r][c]+=1;
                }
            }
        }
        return arr;
    }
}