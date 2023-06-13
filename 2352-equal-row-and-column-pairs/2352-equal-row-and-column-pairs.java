class Solution {
    public int equalPairs(int[][] grid) {
        int ct=0;
        int n=grid.length;
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            String str="";
            for(int j=0;j<n;j++){
                str+=grid[i][j];
                str+=",";
            }
            hm.put(str,hm.getOrDefault(str,0)+1);
        }
        for(int j=0;j<n;j++){
            String str="";
            for(int i=0;i<n;i++){
                str+=grid[i][j];
                str+=",";
            }
            for(String s:hm.keySet()){
                if(s.equals(str)) ct+=hm.get(s);
            }
        }
        return ct;
    }
}



